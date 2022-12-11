package com.oops;

import java.util.*;

class Course implements Comparable<Course>{
    int id;
    String courseId;
    String courseName;
    int courseCredits;
    public Course(int id, String courseId, String courseName, int courseCredits){
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public String toString(){
        return courseId+" "+courseName;
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
        // get from sql
        ArrayList<Course> al = new ArrayList<>();
        al.add(new Course(0, "CS F111", "C P", 4));
        al.add(new Course(1, "CS F112", "C L", 3));
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
    public boolean removeCourse(int id){
        return true;
    }
    public boolean addCourse(String courseName, String courseId, Integer courseCredits){
        return true;
    }
    public boolean setCourse(int id, String courseName, String courseId, Integer courseCredits){
        return true;
    }
    public boolean[] getWeekly(int id){
        return new boolean[]{true,true,true,true,false,false};
    }
    public boolean setWeekly(int id, boolean[] weekly){
        return true;
    }

}
