package com.oops;

import java.util.*;

public class CalendarEvents {
    public static HashMap<String,ArrayList<ArrayList<String>>> getEvents(int year, int month){
        HashMap<String,ArrayList<ArrayList<String>>> events = new HashMap<>();
        ArrayList<ArrayList<String>> al = new ArrayList<>();
        ArrayList<String> ax = new ArrayList<>(Arrays.asList(new String[]{"0","Event 1", "Category1"}));
        al.add(ax);
        al.add(ax);
        events.put(year+"/"+month+"/1", al);
        ArrayList<ArrayList<String>> al_1 = new ArrayList<>();
        ArrayList<String> ax_1 = new ArrayList<>(Arrays.asList(new String[]{"1","Event 2", "Category2"}));
        al_1.add(ax_1);
        events.put(year+"/"+month+"/10", al_1);
        return events;
    }
    public static ArrayList<Object> getEvent(int id){
        ArrayList<Object> al = new ArrayList<>();
        al.add("Event 1");
        al.add("Category1");
        al.add(new Date());
        al.add(true);
        return al;
    }
    public static boolean addEvent(String name, String category, Date date, boolean remind){
        return true;
    }
}
