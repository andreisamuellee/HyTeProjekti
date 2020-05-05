package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn, btnStats;
    EditText et;
    String st, dateString;
    JavaDate dateOlio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        et = findViewById(R.id.edittext);
        btnStats = findViewById(R.id.button3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().toString().matches("[0-99]+")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    dateOlio = new JavaDate();
                    dateString = dateOlio.getDate(0);
                    st = et.getText().toString();
                    storeData();
                    startActivity(intent);
                    finish();
                } else {
                    et.setText("Insert a NUMBER here!");
                }
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    void storeData(){ //Adds amount of smoked smokes to daily number stored in SharedPreferences.
        SharedPreferences prefPut = getSharedPreferences("SmokePref",MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt(dateString, Integer.parseInt(st)+prefPut.getInt(dateString, 0));
        prefEditor.commit();
    }
}