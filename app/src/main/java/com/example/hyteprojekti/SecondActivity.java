package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    String st, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = findViewById(R.id.textView);

        st = getIntent().getExtras().getString("Value");
        date = getIntent().getExtras().getString("Date");

        tv.setText(st + " added to day "+ date +" total.");

    }
}

