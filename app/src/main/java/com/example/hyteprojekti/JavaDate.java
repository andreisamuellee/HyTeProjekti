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

    //returns yesterdays date in dd/MM form with daysBefore = 1, two days ago with daysBefore = 2...
    public String getDate(int daysBefore){
        return df.format(new Date(System.currentTimeMillis()-(daysBefore)*24*60*60*1000));
    }

    //returns current date in dd/MM form.
    public String toString(){
        today = Calendar.getInstance().getTime();
        StringDate = df.format(today);
        return StringDate;
    }
}
