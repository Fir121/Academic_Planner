package com.oops;

import java.util.*;

public class Constants {
    public static final String[] CATEGORIES = new String[]{"Default","Holiday","Component","Event"};
    public static Date START,END;

    static{
        Date now = new Date();
        if (now.compareTo(DateAlternate.date(now.getYear()+"/06/10")) > 0){
            START = DateAlternate.date((now.getYear()+1900)+"/09/01");
            END = DateAlternate.date((now.getYear()+1901)+"/01/20");
        }
        else{
            START = DateAlternate.date((now.getYear()+1900)+"/01/30");
            END = DateAlternate.date((now.getYear()+1900)+"/06/10");
        }
    }
}
