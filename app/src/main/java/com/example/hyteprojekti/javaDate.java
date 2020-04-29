package com.example.hyteprojekti;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class javaDate {

    private java.util.Date today;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private String StringDate;

    javaDate() {
        today = Calendar.getInstance().getTime();
        StringDate = df.format(today);
    }

    public String toString(){
        return StringDate;
    }
}
