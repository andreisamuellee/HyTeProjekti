package com.example.hyteprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hyteprojekti.R;
import com.example.hyteprojekti.SecondActivity;

public class MainActivity extends AppCompatActivity {

    Button btn, btnstats;
    EditText et;
    String st, dateString;
    javaDate dateOlio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        et = findViewById(R.id.edittext);
        btnstats = findViewById(R.id.button3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                dateOlio = new javaDate();
                dateString = dateOlio.getDate(0);
                st = et.getText().toString();
                storeData();
                intent.putExtra("Date",dateString);
                intent.putExtra("Value",st);
                startActivity(intent);
                finish();
            }
        });

        btnstats.setOnClickListener(new View.OnClickListener() {
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