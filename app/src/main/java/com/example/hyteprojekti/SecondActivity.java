package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity{

    private static final String TAG = "SecondActivity";
    private LineChart chart;
    TextView tv;
    String st, date;
    ArrayList<String> days;
    ArrayList<Integer> smokesSmoked;
    javaDate dateOlio;

    int lol = 69;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        testi();
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

   /* public void newArvot(){
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

    } */

    public void testi(){
        chart = (LineChart) findViewById(R.id.chart);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0,10f));
        yValues.add(new Entry(1,20f));
        yValues.add(new Entry(2,30f));
        yValues.add(new Entry(3,40f));

        LineDataSet set1 = new LineDataSet(yValues, "Data Set 1");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet>dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        chart.setData(data);

    }


}

