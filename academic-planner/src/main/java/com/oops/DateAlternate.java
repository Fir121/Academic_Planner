package com.oops;

import java.text.*;
import java.time.*;
import java.util.*;

public class DateAlternate {
    public static Date date(String s){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static int getYear(Date d){
        LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date.getYear();
    }

    public static String getString(Date d){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
        String strDate = formatter.format(d); 
        return strDate; 
    }
}
