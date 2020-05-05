package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

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
        dispText = "A total of "+Integer.toString(smokesSmoked.get(6)) + " smoked today.\n\n"+
                "Average per day this week: "+averageCounter.CountWeek(smokesSmoked)+
                ".\n Average per day this month: "+averageCounter.CountMonth(smokesSmoked);
        tv.setText(dispText);
    }

    @SuppressLint("ResourceAsColor")
    public void testi(){



        chart = (BarChart) findViewById(R.id.chart);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);

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

        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        ArrayList<BarEntry> yValues = new ArrayList<>();

        for (int i = 0; i<7; i++) {
            yValues.add(new BarEntry(i, smokesSmoked.get(i)));
        }

        ArrayList<IBarDataSet>dataSets = new ArrayList<>();
        BarDataSet set1 = new BarDataSet(yValues, "Tupakoita poltettu");
        dataSets.add(set1);
        set1.setValueTextSize(23);
        chart.getLegend().setEnabled(false);
        BarData data = new BarData(dataSets);
        chart.setData(data);
    }
}


