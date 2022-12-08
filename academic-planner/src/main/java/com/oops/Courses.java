package com.oops;

import java.util.*;

public class Courses {
    public static ArrayList<String> getCourses(){
        ArrayList<String> al = new ArrayList<>();
        al.add("CS F111 Comp Prog");
        al.add("CHEM F111 Chem");
        return al;
    }
    public static ArrayList<Object> getCourse(String course){
        return new ArrayList<Object>(Arrays.asList(new Object[]{"Comp prog","CS F111",3}));
    }
    public static boolean removeCourse(String course){
        return true;
    }
    public static boolean addCourse(String courseName, String courseId, Integer courseCredits){
        return true;
    }
    public static boolean setCourse(String course, String courseName, String courseId, Integer courseCredits){
        return true;
    }
    public static boolean[] getWeekly(String course){
        return new boolean[]{true,true,true,true,false,false};
    }
    public static boolean setWeekly(String course, boolean[] weekly){
        return true;
    }
    public static ArrayList<String> getComponents(String course){
        ArrayList<String> al = new ArrayList<>();
        al.add("Date | Component Name %age");
        al.add("Date | Component Name %age");
        return al;
    }
    public static boolean removeComponent(String course, String component){
        return true;
    }
    public static boolean addComponent(String course, String courseName, Date courseId, Double courseCredits){
        return true;
    }
    public static ArrayList<Object> getComponent(String course, String component){
        return new ArrayList<Object>(Arrays.asList(new Object[]{"Component Name",new Date(),20}));
    }
    public static boolean editComponent(String course, String component, String componentName, Date componentDate, Double componentPercentage){
        return true;
    }
}
