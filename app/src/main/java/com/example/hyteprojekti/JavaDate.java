package com.example.hyteprojekti;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDate {

    private java.util.Date today;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM");
    private String StringDate;

    JavaDate() {
    }

    public String getDate(int daysBefore){
        return df.format(new Date(System.currentTimeMillis()-daysBefore*24*60*60*1000));
    }

    public String toString(){
        today = Calendar.getInstance().getTime();
        StringDate = df.format(today);
        return StringDate;
    }
}
