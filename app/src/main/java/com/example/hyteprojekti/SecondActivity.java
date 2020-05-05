package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

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
        //days.add(date);
        for (int i = 0; i<7; i++){
            Log.d("SmokesDay", "for joka lisää string listaan: "+dateOlio.getDate(i));
            days.add(dateOlio.getDate(i));
        }

        SharedPreferences prefGet = getSharedPreferences("SmokePref" ,MainActivity.MODE_PRIVATE);

        //Hakee tallennetusta datasta tupakoiden määrän viimeisen viikon päiviltä
        for (int i = 0; i<7; i++){
            smokesSmoked.add(prefGet.getInt(days.get(i), 0));
        }

        testi();
        dispText = "A total of "+Integer.toString(smokesSmoked.get(0)) + " smoked on "+ days.get(0) +
                ". Average per day this week: "+averageCounter.Count(smokesSmoked);
        tv.setText(dispText);
    }

    public void testi(){
        chart = (BarChart) findViewById(R.id.chart);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        ArrayList<BarEntry> yValues = new ArrayList<>();

        for (int i = 0; i<7; i++) {
            yValues.add(new BarEntry(i, smokesSmoked.get(i)));
        }

        ArrayList<IBarDataSet>dataSets = new ArrayList<>();
        BarDataSet set1 = new BarDataSet(yValues, "Data Set 1");
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        chart.setData(data);
    }
}


