package com.oops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
