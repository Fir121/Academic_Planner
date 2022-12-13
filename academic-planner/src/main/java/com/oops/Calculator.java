package com.oops;


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
    public static String getPredicted(int courseId){
        return "Calcualting";
    }
}
