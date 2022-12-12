package com.oops;

import java.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
// TODO ADD ATTENDANCE CALCULATION FUNCTIONS
class SpecialClass{
    Date date;
    Boolean status;
    public SpecialClass(Date date, Boolean status){
        this.date = date;
        this.status = status;
    }
}
class Attendance{
    int courseid;
    String course;
    boolean hasWeekly;
    boolean[] weekly = new boolean[5];
    ArrayList<Date> absences = new ArrayList<>();
    ArrayList<SpecialClass> specialClasses = new ArrayList<>(); 
    public Attendance(int courseid, String course){
        hasWeekly = false;
        this.courseid = courseid;
        this.course = course;
    }
    public Attendance(int courseid, String course, boolean[] weekly, ArrayList<Date> absences, ArrayList<SpecialClass> specialClasses){
        hasWeekly = true;
        this.courseid = courseid;
        this.course = course;
        this.weekly = weekly;
        this.absences = absences;
        this.specialClasses = specialClasses;
    }
}
public class Attendances {
    ArrayList<Attendance> attendances;
    public Attendances(){
        attendances = getAttendances();
    }
    private ArrayList<Attendance> getAttendances(){
        ArrayList<Attendance> al = new ArrayList<>();
        Courses courses = new Courses();
        for (Course c: courses.courses){
            boolean[] tempWeekly = Courses.getWeekly(c.id);
            boolean flag = false;
            for (int i=0; i<tempWeekly.length; i++){
                if (tempWeekly[i]){
                    al.add(new Attendance(c.id, c.toString(), tempWeekly, getAbsences(c.id), getSpecialClasses(c.id)));
                    flag = true;
                    break;
                }
            }
            if (!flag){
                al.add(new Attendance(c.id, c.toString()));
            }
        }
        return al;
    }
    private static ArrayList<Date> getAbsences(int id){
        ArrayList<Date> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from absences where courseid="+id);
        try{
            while (rs.next()){
                al.add(DateAlternate.date(rs.getString("date")));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        return al;
    }
    private static ArrayList<SpecialClass> getSpecialClasses(int id){
        ArrayList<SpecialClass> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from specialclasses where courseid="+id);
        try{
            while (rs.next()){
                al.add(new SpecialClass(DateAlternate.date(rs.getString("date")), (rs.getInt("active")==1)?true:false));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        return al;
    }

    public static SpecialClass getSpecial(Integer courseid, Date dt){
        ArrayList<SpecialClass> al = getSpecialClasses(courseid);
        for (SpecialClass sc: al){
            if (sc.date.equals(dt)){
                return sc;
            }
        }
        return null;
    }
    
    public Attendance getAttendance(Integer courseid){
        for (Attendance attendance: attendances){
            if (attendance.courseid == courseid){
                return attendance;
            }
        }
        return null;
    }

    public static boolean toggleSpecial(int courseid, Date dt, int status){
        SpecialClass scob = getSpecial(courseid, dt); 
        if (scob != null){
            if (scob.status){
                return new SQL().changeData("update specialclasses set active=0 where courseid=? and date=?", courseid, DateAlternate.getString(dt));
            }
            else{
                return new SQL().changeData("update specialclasses set active=1 where courseid=? and date=?", courseid, DateAlternate.getString(dt));
            }
        }
        else{
            return new SQL().changeData("insert into specialclasses values(?,?,?)", courseid, DateAlternate.getString(dt), (status==1)?0:1);
        }
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
        ArrayList<Date> al = getAbsences(courseid);
        if (al.contains(dt)){
            return new SQL().changeData("delete from absences where courseid=? and date=?", courseid, DateAlternate.getString(dt));
        }
        else{
            return new SQL().changeData("insert into absences values(?,?)", courseid, DateAlternate.getString(dt));
        }
    }
}
