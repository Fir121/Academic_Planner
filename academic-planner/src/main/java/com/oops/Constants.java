package com.oops;

import java.util.*;

public class Constants {
    public static final String[] CATEGORIES = new String[]{"Default","Holiday","Component","Event"};
    public static Date START,END;

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
    }
}
