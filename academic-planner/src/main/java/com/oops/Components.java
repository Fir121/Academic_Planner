package com.oops;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class Component implements Comparable<Component>{
    private int id;
    private String componentName;
    private Date componentDate;
    private double componentPercentage;
    private Double componentMarks;
    public Component(int id, String componentName, Date componentDate, double componentPercentage, Double componentMarks){
        this.id = id;
        this.componentName = componentName;
        this.componentDate = componentDate;
        this.componentPercentage = componentPercentage;
        this.componentMarks = componentMarks;
    }
    public int getId() {
        return id;
    }
    public String getComponentName() {
        return componentName;
    }
    public Date getComponentDate() {
        return componentDate;
    }
    public double getComponentPercentage() {
        return componentPercentage;
    }
    public Double getComponentMarks() {
        return componentMarks;
    }
    public int compareTo(Component c){
        return componentDate.compareTo(c.componentDate);
    }
}

public class Components {
    private int courseId;
    private ArrayList<Component> components;
    public Components(int courseId){
        this.courseId = courseId;
        components = getComponents(courseId);
        Collections.sort(components);
    }
    private ArrayList<Component> getComponents(int courseId){
        ArrayList<Component> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from components where courseid="+courseId);
        try{
            while (rs.next()){
                Double dub = rs.getDouble("marks");
                if (rs.wasNull()){
                    dub = null;
                }
                al.add(new Component(rs.getInt("id"), rs.getString("name"), DateAlternate.date(rs.getString("date")), rs.getDouble("percentage"), dub));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        return al;
    }

    public int getCourseId(){
        return courseId;
    }
    public ArrayList<Component> getArrayListComponents(){
        return components;
    }

    public static boolean removeComponent(int id){
        return new SQL().changeData("delete from components where id=?",id);
    }
    public static boolean addComponent(int courseId, String componentName, Date componentDate, Double componentPercentage){
        Components all = new Components(courseId);
        double total_percentage = 0;
        for (Component c: all.components){
            total_percentage += c.getComponentPercentage();
        }
        if (total_percentage+componentPercentage > 100.0){
            PopupFrame.showErrorMessage("Invalid Percentage");
            return false;
        }
        return new SQL().changeData("insert into components('courseid', 'name', 'date', 'percentage') values(?,?,?,?)",courseId,componentName,DateAlternate.getString(componentDate),componentPercentage);
    }
    public Component getComponent(int id){
        for (Component component: components){
            if (component.getId() == id){
                return component;
            }
        }
        return null;
    }
    public static boolean editComponent(int courseId, int id, String componentName, Date componentDate, Double componentPercentage){
        Components all = new Components(courseId);
        double total_percentage = 0;
        for (Component c: all.components){
            total_percentage += c.getComponentPercentage();
        }
        if (total_percentage+componentPercentage > 100.0){
            PopupFrame.showErrorMessage("Invalid Percentage");
            return false;
        }
        return new SQL().changeData("update components set name=?, date=?, percentage=? where id=?",componentName,DateAlternate.getString(componentDate),componentPercentage,id);
    }

    public static boolean setMarks(int courseId, int id, Double marks){
        Course course = new Courses().getCourse(courseId);
        Component component = new Components(courseId).getComponent(id);
        Double max = course.getCourseCredits() * component.getComponentPercentage();
        if (marks > max){
            PopupFrame.showErrorMessage("Invalid marks, as per credits max marks = "+max);
            return false;
        }
        return new SQL().changeData("update components set marks=? where id=?", marks, id);
    }
}
