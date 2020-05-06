package com.example.hyteprojekti;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDate {

    private java.util.Date today;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM");
    private String StringDate;

    /**
     * Empty class constructor.
     */
    JavaDate() {
    }


    /**
     * Used to get dates of gone by days.
     * Returns yesterdays date in dd/MM form with daysBefore = 1, two days ago with daysBefore = 2...
     *
     * @param daysBefore daysBefore = 1 is yesterdays date. Two days ago with daysBefore = 2...
     * @return Returns date in dd/MM String form
     */
    public String getDate(int daysBefore){
        return df.format(new Date(System.currentTimeMillis()-(daysBefore)*24*60*60*1000));
    }

    /**
     * Used to get current date.
     *
     * @return Returns current date in dd/MM String form
     */
    public String toString(){
        today = Calendar.getInstance().getTime();
        StringDate = df.format(today);
        return StringDate;
    }
}
