package com.oops;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class Event{
    int id;
    String eventName;
    String category;
    Date date;
    boolean reminder;
    public Event(int id, String eventName, String category, Date date, boolean reminder){
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.reminder = reminder;
        for (int i=0; i<Constants.CATEGORIES.length; i++){
            if (Constants.CATEGORIES[i].equalsIgnoreCase(category)){
                this.category = Constants.CATEGORIES[i];
                return;
            }
        }
        this.category = Constants.CATEGORIES[0];
    }
}

public class CalendarEvents {
    ArrayList<Event> events;
    public CalendarEvents(int year, int month){
        events = getEvents(year,month);
    }
    private ArrayList<Event> getEvents(int year, int month){
        // get events from sql and store in ARRAYLIST with event objects
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(1,"Event 1", "Holiday", DateAlternate.date(year+"/"+month+"/1"), false));
        events.add(new Event(2,"Event 2", "Component", DateAlternate.date(year+"/"+month+"/2"), false));
        return events;
    }
    
    public static boolean addEvent(String name, String category, Date date, boolean remind){
        // add event to db
        return true;
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
