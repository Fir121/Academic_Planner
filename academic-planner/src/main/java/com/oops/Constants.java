package com.oops;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Constants {
    public static final String[] CATEGORIES = new String[]{"Default","Holiday","Event"};
    public static Date START,END;
    public static final String[] GRADES = new String[]{"Unknown","A","A-","B","B-","C","C-","D","D-","E","E-","F"};

    static{
        Date now = new Date();
        if (now.compareTo(DateAlternate.date(DateAlternate.getYear(now)+"/06/10")) > 0){
            START = DateAlternate.date(DateAlternate.getYear(now)+"/09/01");
            END = DateAlternate.date(DateAlternate.getYear(now)+1+"/01/20");
        }
        else{
            START = DateAlternate.date(DateAlternate.getYear(now)+"/01/30");
            END = DateAlternate.date(DateAlternate.getYear(now)+"/06/10");
        }

        try{
            File f = new File("startdate");
            if(f.exists()) { 
                Scanner myReader = new Scanner(f);
                String data = "";
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                }
                Date x = DateAlternate.date(data);
                if (x != null){
                    START = x;
                }
                myReader.close();
            }
        }
        catch(Exception e){}

        try{
            File f = new File("enddate");
            if(f.exists()) { 
                Scanner myReader = new Scanner(f);
                String data = "";
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                }
                Date x = DateAlternate.date(data);
                if (x != null){
                    END = x;
                }
                myReader.close();
            }
        }
        catch(Exception e){}
    }

    public static boolean setStartDate(Date dt){
        if (dt.equals(END) || dt.after(END)){
            return false;
        }
        try {
            Writer fileWriter = new FileWriter("startdate.txt", false);
            fileWriter.write(DateAlternate.getString(dt)+"\n");
            fileWriter.close();

            START = dt;
            return true;
        } 
        catch (IOException e) {
            return false;
        }
    }
    public static boolean setEndDate(Date dt){
        if (dt.equals(START) || dt.before(START)){
            return false;
        }
        try {
            Writer fileWriter = new FileWriter("enddate.txt", false);
            fileWriter.write(DateAlternate.getString(dt)+"\n");
            fileWriter.close();

            END = dt;
            return true;
        } 
        catch (IOException e) {
            return false;
        }
    }
}
