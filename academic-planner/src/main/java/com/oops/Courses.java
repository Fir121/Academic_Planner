package com.oops;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class Course implements Comparable<Course>{
    int id;
    String courseCode;
    String courseName;
    int courseCredits;
    public Course(int id, String courseCode, String courseName, int courseCredits){
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public String toString(){
        return courseCode+" "+courseName;
    }
    public int compareTo(Course c){
        return id-c.id;
    }
}
public class Courses {
    ArrayList<Course> courses;
    public Courses(){
        courses = getCourses();
        Collections.sort(courses);
    }
    private ArrayList<Course> getCourses(){
        ArrayList<Course> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from courses");
        try{
            while (rs.next()){
                al.add(new Course(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getInt("credits")));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        
        return al;
    }
    public Course getCourse(int id){
        for (Course course: courses){
            if (course.id == id){
                return course;
            }
        }
        return null;
    }
    public static boolean removeCourse(int id){
        return new SQL().changeData("delete from courses where id=?",id);
    }
    public static boolean addCourse(String courseName, String courseCode, Integer courseCredits){
        SQL sql = new SQL();
        if (sql.changeData("insert into courses('name', 'code', 'credits') values(?,?,?)",courseName,courseCode,courseCredits)){
            SQL.initiateConnection();
            return sql.changeData("insert into weekly('courseid') values((select seq from sqlite_sequence where name='Courses'))");
        }
        return false;
    }
    public static boolean setCourse(int id, String courseName, String courseCode, Integer courseCredits){
        return new SQL().changeData("update courses set name=?, code=?, credits=? where id=?",courseName,courseCode,courseCredits,id);
    }
    public static boolean[] getWeekly(int id){
        boolean[] weekly = new boolean[]{false,false,false,false,false};
        ResultSet rs = new SQL().selectData("select * from weekly where courseid="+id);
        try{
            while (rs.next()){
                weekly[0] = rs.getInt("monday") == 1;
                weekly[1] = rs.getInt("tuesday") == 1;
                weekly[2] = rs.getInt("wednesday") == 1;
                weekly[3] = rs.getInt("thursday") == 1;
                weekly[4] = rs.getInt("friday") == 1;
            }
        }
        catch(SQLException e){}

        return weekly;
    }
    public static boolean setWeekly(int id, boolean[] weekly){
        return new SQL().changeData("update weekly set monday=?, tuesday=?, wednesday=?, thursday=?, friday=? where courseid=?",(weekly[0]) ? 1:0, (weekly[1]) ? 1:0, (weekly[2]) ? 1:0, (weekly[3]) ? 1:0, (weekly[4]) ? 1:0,id);
    }

}
