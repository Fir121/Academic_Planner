package com.oops;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class Component implements Comparable<Component>{
    int id;
    String componentName;
    Date componentDate;
    double componentPercentage;
    public Component(int id, String componentName, Date componentDate, double componentPercentage){
        this.id = id;
        this.componentName = componentName;
        this.componentDate = componentDate;
        this.componentPercentage = componentPercentage;
    }
    public int compareTo(Component c){
        return componentDate.compareTo(c.componentDate);
    }
}

public class Components {
    int courseId;
    ArrayList<Component> components;
    public Components(int courseId){
        this.courseId = courseId;
        components = getComponents(courseId);
    }
    private ArrayList<Component> getComponents(int courseId){
        ArrayList<Component> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from components where courseid="+courseId);
        try{
            while (rs.next()){
                al.add(new Component(rs.getInt("id"), rs.getString("name"), DateAlternate.date(rs.getString("date")), rs.getDouble("percentage")));
            }
        }
        catch (SQLException e){}
        return al;
    }
    public static boolean removeComponent(int id){
        return new SQL().changeData("delete from components where id=?",id);
    }
    public static boolean addComponent(int courseId, String componentName, Date componentDate, Double componentPercentage){
        return new SQL().changeData("insert into components('courseid', 'name', 'date', 'percentage') values(?,?,?,?)",courseId,componentName,DateAlternate.getString(componentDate),componentPercentage);
    }
    public Component getComponent(int id){
        for (Component component: components){
            if (component.id == id){
                return component;
            }
        }
        return null;
    }
    public boolean editComponent(int id, String componentName, Date componentDate, Double componentPercentage){
        return new SQL().changeData("update components set name=?, date=?, percentage=? where id=?",componentName,DateAlternate.getString(componentDate),componentPercentage,id);
    }
}
