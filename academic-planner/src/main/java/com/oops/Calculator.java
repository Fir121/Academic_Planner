package com.oops;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Calculator {
    public static String calculateRange(Double avg){
        return "A > "+String.format("%.2f",avg*1.8)+"\n"+
        "A- > "+String.format("%.2f",avg*1.5)+"\n"+
        "B > "+String.format("%.2f",avg*1.25)+"\n"+
        "B- > "+String.format("%.2f",avg)+"\n"+
        "C > "+String.format("%.2f",avg*0.8)+"\n"+
        "C- > "+String.format("%.2f",avg*0.7)+"\n"+
        "D > "+String.format("%.2f",avg*0.6)+"\n"+
        "D- > "+String.format("%.2f",avg*0.5)+"\n"+
        "E > "+String.format("%.2f",avg*0.4)+"\n"+
        "E- > "+String.format("%.2f",avg*0.3);
    }
    private static Double getAverage(String grade, Double marks){
        switch(grade){
            case "A": return marks/1.8;
            case "A-": return marks/1.5;
            case "B": return marks/1.25;
            case "B-": return marks;
            case "C": return marks/0.8;
            case "C-": return marks/0.7;
            case "D": return marks/0.6;
            case "D-": return marks/0.5;
            case "E": return marks/0.4;
            case "E-": return marks/0.3;
            default: return 0.0;
        }
    }
    public static String getPredicted(int courseId){
        Course course = new Courses().getCourse(courseId);
        Components components = new Components(courseId);

        if (course.grade.equals("Unknown")){
            return "<html>Please fill in your current Grade<br/>You may use the calculator below</html>";
        }
        Double gotMarks = 0.0;
        Double totalMarks = 0.0;
        for (Component c: components.components){
            if (c.componentDate.compareTo(new Date()) <= 0){
                if (c.componentMarks == null){
                    return "<html>Please fill in all possible marks<br/>before we can estimate a grade!</html>";
                }
                gotMarks += c.componentMarks;
                totalMarks += c.componentPercentage*course.courseCredits;
            }
        }
        Double avg = getAverage(course.grade, gotMarks);
        return "X";
    }

    public static String getAttendanceStats(int courseId){
        Double attendedClasses = 0.0;
        Double totalClassesToDate = 0.0;
        Double totalClasses = 0.0;

        Attendance attendance = new Attendances().getAttendance(courseId);
        int year = DateAlternate.getYear(Constants.START);
        int month = DateAlternate.getMonth(Constants.START);
        CalendarEvents events = new CalendarEvents(year, month);

        for (Date date = Constants.START; date.before(Constants.END); date = Date.from(date.toInstant().plus(1,ChronoUnit.DAYS))) {
            if (DateAlternate.getYear(date) != year || DateAlternate.getMonth(date) != month){
                year = DateAlternate.getYear(date);
                month = DateAlternate.getMonth(date);
                events = new CalendarEvents(year, month);
            }
            boolean flag = false;
            for (int i=0; i<attendance.specialClasses.size();i++){
                if (attendance.specialClasses.get(i).date.equals(date)){
                    flag = true;
                    if (attendance.specialClasses.get(i).status){
                        totalClasses++;
                        if (date.before(new Date()) || date.equals(new Date())){
                            totalClassesToDate++;
                            if (!attendance.absences.contains(date)){
                                attendedClasses++;
                            }
                        }
                    }
                }
            }
            if (!flag){
                boolean notworking = false;
                for (Event ex: events.getEventsOnDate(DateAlternate.getString(date))){
                    if (ex.category.equals("Holiday")){
                        notworking = true;break;
                    }
                    else if (ex.category.equals("Component")){
                        notworking = true;break;
                    }
                }

                if (Attendances.compareDateToWeekArray(date, attendance.weekly) && !notworking){
                    totalClasses++;
                    if (date.before(new Date()) || date.equals(new Date())){
                        totalClassesToDate++;
                        if (!attendance.absences.contains(date)){
                            attendedClasses++;
                        }
                    }
                }
            }
        }
        try{
            return "<html>Attended Classes: "+attendedClasses+
            "<br/>Classes To Date: "+totalClassesToDate+
            "<br/>Total Classes: "+totalClasses+
            "<br/>Remaining Classes: "+(totalClasses-totalClassesToDate)+
            "<br/><br/>Current Attendance: "+String.format("%.2f", (attendedClasses/totalClassesToDate)*100)+"%"+
            "<br/>End Of Sem Attendance: "+String.format("%.2f", (attendedClasses/totalClasses)*100)+"%</html>";

        }
        catch(ArithmeticException e){
            return "Error";
        }
    }
}
