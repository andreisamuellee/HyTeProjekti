package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    String st, date;
    ArrayList<String> days;
    ArrayList<Integer> smokesSmoked;
    javaDate dateOlio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        days = new ArrayList<>();
        smokesSmoked = new ArrayList<>();
        dateOlio = new javaDate();

        tv = findViewById(R.id.textView);
        st = getIntent().getExtras().getString("Value");
        date = getIntent().getExtras().getString("Date");

        days.add(date);
        for (int i = 1; i>7; i++){
            days.add(dateOlio.getDate(i));
        }

        SharedPreferences prefGet = getSharedPreferences("SmokePref" ,MainActivity.MODE_PRIVATE);

        for (int i = 1; i>7; i++){
            smokesSmoked.add(prefGet.getInt(days.get(i-1), 0));
        }

        //tv.setText(Integer.toString(smokesSmoked.get(0)) + " added to day "+ days.get(0) +" total.");

        tv.setText(st + " added to day "+ date +" total.");

    }
}

