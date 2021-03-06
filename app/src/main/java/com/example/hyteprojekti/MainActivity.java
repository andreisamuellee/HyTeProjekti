package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toasts toastStrings;
    private EditText et;
    private TextView info;
    private String st, dateString;
    private JavaDate dateOlio;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.edittext);
        info = findViewById(R.id.infoText);
        toastStrings = new Toasts();
        handler = new Handler();
        rollInfo();
    }

    /**
     * Main button used to add smokes and move to the second activity.
     * @param view used for button onClick()
     */
    public void inputTobaccos(View view){
        if (et.getText().toString().matches("[0-99]+")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            dateOlio = new JavaDate();
            dateString = dateOlio.getDate(0);
            st = et.getText().toString();
            storeData();
            startActivity(intent);
            finish();
        } else {
            et.setHint("Insert a NUMBER here!");
        }
    }

    /**
     * Second button used to move straight to second activity.
     * @param view used for button onClick()
     */
    public void goToStatistics(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * Runs info swapper
     */
    private void rollInfo() {
        handler.post(run);
    }

    /**
     * Swaps out info every 5 seconds
     */
    private Runnable run = new Runnable() {
        @Override
        public void run() {
            info.setText(toastStrings.toString());
            handler.postDelayed(this, 5000);
        }
    };
    /**
     * Stores data to SharedPreferences
     */
    private void storeData(){
        SharedPreferences prefPut = getSharedPreferences("SmokePref",MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt(dateString, Integer.parseInt(st)+prefPut.getInt(dateString, 0));
        prefEditor.commit();
    }
}