package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    String st, date;
    //LineChart chart = (LineChart) findViewById(R.id.chart);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = findViewById(R.id.textView);

        st = getIntent().getExtras().getString("Value");
        date = getIntent().getExtras().getString("Date");

        tv.setText(st + " added to day "+ date +" total.");
        //newArvot();

    }
/*
    public void newArvot(String x, int y){
        List<Entry> entries = new ArrayList<Entry>();
        for (int i = 0; i<10; i++) {
            // turn your data into Entry objects
            entries.add(new Entry(i, 2*i));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED); // styling, ..

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
  */

}

