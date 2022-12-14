package com.oops;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

public class Calculator {
    public static String calculateRange(Double avg, Double marks){
        if (marks >= avg*1.8){
            return "A";
        }
        else if (marks >= avg*1.5){
            return "A-";
        }
        else if (marks >= avg*1.25){
            return "B";
        }
        else if (marks >= avg){
            return "B-";
        }
        else if (marks >= avg*0.8){
            return "C";
        }
        else if (marks >= avg*0.7){
            return "C-";
        }
        else if (marks >= avg*0.6){
            return "D";
        }
        else if (marks >= avg*0.5){
            return "D-";
        }
        else if (marks >= avg*0.4){
            return "E";
        }
        else if (marks >= avg*0.3){
            return "E-";
        }
        else{
            return "Could Not Determine";
        }
    }
    private static Double getAverage(String grade, Double marks){
        switch(grade){
            case "A": return (marks)/1.8;
            case "A-": return (marks)/1.5;
            case "B": return (marks)/1.25;
            case "B-": return (marks);
            case "C": return (marks)/0.8;
            case "C-": return (marks)/0.7;
            case "D": return (marks)/0.6;
            case "D-": return (marks)/0.5;
            case "E": return (marks)/0.4;
            case "E-": return (marks)/0.3;
            default: return 0.0;
        }
    }
    public static String getPredicted(int courseId){ // ROUGH ALGORITHM THAT CALCULATES A PREDICTED GRADE BASED ON ATTENDANCE, MORE RELIABLE AFTER ADDING MORE DATA!
        Course course = new Courses().getCourse(courseId);
        Components components = new Components(courseId);

        if (course.grade.equals("Unknown")){
            return "<html>Please fill in your current Grade<br/>You may use the calculator below</html>";
        }
        if (components.getArrayListComponents().size() == 0){
            return "No components added!";
        }
        Double gotMarks = 0.0;
        Double totalMarks = 0.0;
        for (Component c: components.getArrayListComponents()){
            if (c.getComponentDate().compareTo(new Date()) <= 0){
                if (c.getComponentMarks() == null){
                    return "<html>Please fill in all possible marks<br/>before we can estimate a grade!</html>";
                }
                gotMarks += c.getComponentMarks();
                totalMarks += c.getComponentPercentage()*course.getCourseCredits();
            }
        }
        Double avg = getAverage(course.grade, gotMarks);

        // ATTENDANCE DATA TILL LAST COMPONENT
        HashMap<String,Double> dataComponent = generateAttendanceReport(courseId, components.getArrayListComponents().get(components.getArrayListComponents().size()-1).getComponentDate());
        Double attendedClassesComponent = dataComponent.get("attended");
        Double totalClassesToDateComponent = dataComponent.get("tilldate");
        Double attPercentageComponent = attendedClassesComponent/totalClassesToDateComponent;

        // ATTENDANCE DATA TILL TODAY
        HashMap<String,Double> data = generateAttendanceReport(courseId, new Date());
        Double attendedClasses = data.get("attended");
        Double totalClassesToDate = data.get("tilldate");
        Double attPercentage = attendedClasses/totalClassesToDate;

        Double extrapolatedClassMarks = (avg/totalMarks)*100;
        Double yourExtrapolatedMarks = (((gotMarks/attPercentageComponent)*attPercentage)/totalMarks)*100;

        return calculateRange(extrapolatedClassMarks, yourExtrapolatedMarks);
    }

    private static HashMap<String,Double> generateAttendanceReport(int courseId, Date finalDate){
        HashMap<String,Double> data = new HashMap<>();

        Double attendedClasses = 0.0;
        Double totalClassesToDate = 0.0;
        Double totalClasses = 0.0;

        Attendance attendance = new Attendances().getAttendance(courseId);
        int year = DateAlternate.getYear(Constants.START);
        int month = DateAlternate.getMonth(Constants.START);
        CalendarEvents events = new CalendarEvents(year, month);

        Date end = (finalDate == null)?Constants.END : finalDate;

        for (Date date = Constants.START; date.before(end) || date.equals(end); date = Date.from(date.toInstant().plus(1,ChronoUnit.DAYS))) {
            if (DateAlternate.getYear(date) != year || DateAlternate.getMonth(date) != month){
                year = DateAlternate.getYear(date);
                month = DateAlternate.getMonth(date);
                events = new CalendarEvents(year, month);
            }
            boolean flag = false;
            for (int i=0; i<attendance.getSpecialClasses().size();i++){
                if (attendance.getSpecialClasses().get(i).getDate().equals(date)){
                    flag = true;
                    if (attendance.getSpecialClasses().get(i).getStatus()){
                        totalClasses++;
                        if (date.before(new Date()) || date.equals(new Date())){
                            totalClassesToDate++;
                            if (!attendance.getAbsences().contains(date)){
                                attendedClasses++;
                            }
                        }
                    }
                }
            }
            if (!flag){
                boolean notworking = false;
                for (Event ex: events.getEventsOnDate(DateAlternate.getString(date))){
                    if (ex.getCategory().equals("Holiday")){
                        notworking = true;break;
                    }
                    else if (ex.getCategory().equals("Component")){
                        notworking = true;break;
                    }
                }

                if (Attendances.compareDateToWeekArray(date, attendance.getWeekly()) && !notworking){
                    totalClasses++;
                    if (date.before(new Date()) || date.equals(new Date())){
                        totalClassesToDate++;
                        if (!attendance.getAbsences().contains(date)){
                            attendedClasses++;
                        }
                    }
                }
            }
        }

        data.put("attended",attendedClasses);
        data.put("tilldate", totalClassesToDate);
        data.put("total",totalClasses);

        return data;
    }

    public static String getAttendanceStats(int courseId){
        HashMap<String,Double> data = generateAttendanceReport(courseId, null);
        Double attendedClasses = data.get("attended");
        Double totalClassesToDate = data.get("tilldate");
        Double totalClasses = data.get("total");
        try{
            return "<html>Attended Classes: "+attendedClasses+
            "<br/>Classes To Date: "+totalClassesToDate+
            "<br/>Total Classes: "+totalClasses+
            "<br/>Remaining Classes: "+(totalClasses-totalClassesToDate)+
            "<br/><br/>Current Attendance: "+String.format("%.2f", (attendedClasses/totalClassesToDate)*100)+"%"+
            "<br/>End Of Sem Attendance: "+String.format("%.2f", (attendedClasses/totalClasses)*100)+"%</html>";

        }
        catch(Exception e){
            return "Error";
        }
    }
}
