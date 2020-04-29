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

    Button btn;
    EditText et;
    String st, dateString;
    javaDate dateOlio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SharedPreferences prefGet = getSharedPreferences("SmokePref" ,MainActivity.MODE_PRIVATE);

        btn = findViewById(R.id.button);
        et = findViewById(R.id.edittext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                dateOlio = new javaDate();
                dateString = dateOlio.toString();
                st = et.getText().toString();

                intent.putExtra("Date",dateString);
                intent.putExtra("Value",st);
                startActivity(intent);
                finish();

            }
        });
    }
}