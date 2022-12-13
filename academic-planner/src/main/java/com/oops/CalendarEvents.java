package com.oops;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class Event{
    Integer id;
    String eventName;
    String category;
    Date date;
    Boolean reminder;
    public Event(Integer id, String eventName, String category, Date date, Boolean reminder){
        this.id = id;
        this.eventName = eventName;
        this.category = category;
        this.date = date;
        this.reminder = reminder;
    }
}

public class CalendarEvents {
    ArrayList<Event> events;
    public CalendarEvents(int year, int month){
        events = getEvents(year,month);
    }
    private ArrayList<Event> getEvents(int year, int month){
        ArrayList<Event> al = new ArrayList<>();
        ResultSet rs = new SQL().selectData("select * from events where date like '"+year+"/"+String.format("%02d",month)+"/%'");
        try{
            while (rs.next()){
                al.add(new Event(rs.getInt("id"), rs.getString("name"), rs.getString("category"), DateAlternate.date(rs.getString("date")), (rs.getInt("reminder") == 1)?true:false));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        rs = new SQL().selectData("select courses.code || '<br/>' || components.name as 'name', components.date as 'date' from components join courses;");
        try{
            while (rs.next()){
                al.add(new Event(null, "<html>"+rs.getString("name")+"</html>", "Component", DateAlternate.date(rs.getString("date")), null));
            }
        }
        catch (SQLException e){}
        finally{
            SQL.closeConn();
        }
        return al;
    }
    
    public static boolean addEvent(String name, String category, Date date, boolean remind){
        return new SQL().changeData("insert into events('name', 'category', 'date', 'reminder') values(?,?,?,?)",name,category,DateAlternate.getString(date),(remind)?1:0);
    }

    public static boolean editEvent(int id, String name, String category, Date date, boolean remind){
        return new SQL().changeData("update events set name=?, category=?, date=?, reminder=? where id=?",name,category,DateAlternate.getString(date),(remind)?1:0,id);
    }

    public static boolean deleteEvent(int id){
        return new SQL().changeData("delete from events where id=?",id);
    }

    public Event getEvent(int id){
        for (Event event: events){
            if (event.id == id){
                return event;
            }
        }
        return null;
    }

    public boolean containsDate(String date){
        Date dt =  DateAlternate.date(date);
        for (Event event: events){
            if (event.date.equals(dt)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Event> getEventsOnDate(String date){
        ArrayList<Event> al = new ArrayList<>();
        Date dt =  DateAlternate.date(date);
        for (Event event: events){
            if (event.date.equals(dt)){
                al.add(event);
            }
        }
        return al;
    }
}
