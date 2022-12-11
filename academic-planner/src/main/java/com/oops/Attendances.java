package com.oops;

import java.util.*;

class Attendance{
    int courseid;
    String course;
    boolean hasWeekly;
    boolean[] weekly = new boolean[5];
    ArrayList<Date> absences = new ArrayList<>();
    public Attendance(int courseid, String course){
        hasWeekly = false;
        this.courseid = courseid;
        this.course = course;
    }
    public Attendance(int courseid, String course, boolean[] weekly, ArrayList<Date> absences){
        hasWeekly = true;
        this.courseid = courseid;
        this.course = course;
        this.weekly = weekly;
        this.absences = absences;
    }
}

public class Attendances {
    ArrayList<Attendance> attendances;
    public Attendances(){
        attendances = getAttendances();
    }
    private ArrayList<Attendance> getAttendances(){
        ArrayList<Attendance> al = new ArrayList<>();
        al.add(new Attendance(0, "CS F15 CP"));
        al.add(new Attendance(1, "CS F15 CP", new boolean[]{true,true,true,true,false}, new ArrayList<Date>()));
        return al;
    }
    public Attendance getAttendance(Integer courseid){
        if (courseid == null){
            return null;
        }
        ArrayList<Date> al = new ArrayList<>();
        al.add(new Date("2022/12/12"));
        return new Attendance(1, "CS F15 CP", new boolean[]{true,true,true,true,false}, al);
    }
    
    public static boolean compareDateToWeekArray(Date dt, boolean[] weekly){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7){
            return false;
        }
        return weekly[dayOfWeek-2];
    }

    public static boolean toggleAttendance(Integer courseid, Date dt){
        return true;
    }
}
