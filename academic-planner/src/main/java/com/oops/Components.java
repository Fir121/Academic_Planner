package com.oops;

import java.util.*;

class Component implements Comparable<Component>{
    int id;
    String componentName;
    Date componentDate;
    double componentPercentage;
    public Component(int id, String componentName, Date componentDate, double componentPercentage){
        this.id = id;
        this.componentName = componentName;
        this.componentDate = componentDate;
        this.componentPercentage = componentPercentage;
    }
    public int compareTo(Component c){
        return componentDate.compareTo(c.componentDate);
    }
}

public class Components {
    int courseId;
    ArrayList<Component> components;
    public Components(int courseId){
        this.courseId = courseId;
        components = getComponents(courseId);
    }
    private ArrayList<Component> getComponents(int courseId){
        ArrayList<Component> al = new ArrayList<>();
        al.add(new Component(0, "T1", new Date("2022/12/4"), 25.0));
        al.add(new Component(1, "T1", new Date("2022/12/4"), 25.0));
        return al;
    }
    public boolean removeComponent(int id){
        return true;
    }
    public boolean addComponent(String componentName, Date componentDate, Double componentPercentage){
        return true;
    }
    public Component getComponent(int id){
        return new Component(0, "T1", new Date("2022/12/4"), 25.0);
    }
    public boolean editComponent(int id, String componentName, Date componentDate, Double componentPercentage){
        return true;
    }
}
