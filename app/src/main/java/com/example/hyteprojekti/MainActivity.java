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

        String[] randomStrings = new String[]{"There are 1.1 billion smokers", "Smoking is the cause of 1 in 5 deaths",
                "A single cigarette contains over 4,800 chemicals", "Smoking increases your risk of getting lung diseases",
                "Tobacco kills up to half of its users", "Tobacco kills more than 8 million people each year",
                "Second-hand smoke causes 1.2 million premature deaths per year", "Adult male smokers lose an average of 13.2 years of life",
                "Around 10 million cigarettes are purchased per minute", "There are more than 4,000 chemicals in tobacco smoke",
                "Second hand smoking kills", "There is no safe level of exposure to secondhand smoke",
                "Tobacco contains arsenic", "Tobacco contains cyanide", "Ninety percent of lung cancer cases are due to smoking",
                "Smoking raises blood pressure", "Smoking stains your teeth and gums", "Life insurance is more expensive"};
        Toast.makeText(getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length - 1)], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length - 1)], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length - 1)], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length - 1)], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), randomStrings[new Random().nextInt(randomStrings.length - 1)], Toast.LENGTH_LONG).show();

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