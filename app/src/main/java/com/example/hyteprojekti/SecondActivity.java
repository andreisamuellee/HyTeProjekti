package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Button btnBack;

    private static final String TAG = "SecondActivity";
    BarChart chart;
    TextView tv;
    ArrayList<String> days;
    ArrayList<Integer> smokesSmoked;
    JavaDate dateOlio;
    AverageCounter averageCounter;
    String dispText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        days = new ArrayList<>();
        smokesSmoked = new ArrayList<>();
        dateOlio = new JavaDate();
        tv = findViewById(R.id.textView);
        averageCounter = new AverageCounter();
        btnBack = findViewById(R.id.Back);

        //Laittaa viimeisen viikon päivät listaan muodossa String "dd/mm"
        for (int i = 30; i>0; i--){
            days.add(dateOlio.getDate(i - 24));
        }

        SharedPreferences prefGet = getSharedPreferences("SmokePref" ,MainActivity.MODE_PRIVATE);

        //Hakee tallennetusta datasta tupakoiden määrän viimeisen viikon päiviltä
        for (int i = 0; i<30; i++){
            smokesSmoked.add(prefGet.getInt(days.get(i), 0));
        }

        testi();
        Toast.makeText(getApplicationContext(), "A total of "+Integer.toString(smokesSmoked.get(6)) + " smoked today.", Toast.LENGTH_SHORT).show();
        dispText = "Average per day last 7 days: "+averageCounter.CountWeek(smokesSmoked)+
                ".\n Average per day last 30 days: "+averageCounter.CountMonth(smokesSmoked);
        tv.setText(dispText);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void testi(){

        ///find the view
        chart = (BarChart) findViewById(R.id.chart);

        ///Specifies how the chart should look and what it shows
        chart.getAxisLeft().setAxisMinimum(1f);
        chart.getAxisRight().setAxisMinimum(1f);

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        chart.setBackgroundColor(Color.WHITE);
        chart.getDescription().setEnabled(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.setExtraOffsets(0f,0f,0f,15f);

        ///Change the x-axis labels from float to date
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));

        ///Create ArrayList to put the y-axis values to
        ArrayList<BarEntry> yValues = new ArrayList<>();

        ///Tell chart how many bars it should show and what values to put in them
        for (int i = 0; i<7; i++) {
            yValues.add(new BarEntry(i, smokesSmoked.get(i)));
        }

        ///Create list where you put your data sets
        ArrayList<IBarDataSet>dataSets = new ArrayList<>();

        ///Create new data set
        BarDataSet set1 = new BarDataSet(yValues, "Tupakoita poltettu");

        ///Add your new data set to list of data sets
        dataSets.add(set1);

        ///Make it look good
        set1.setValueTextSize(23);
        chart.getLegend().setEnabled(false);

        ///Show your data sets in your chart
        BarData data = new BarData(dataSets);
        chart.setData(data);
    }
}


