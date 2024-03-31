package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ResourceBundle;

public class MainActivity2 extends AppCompatActivity {
    private Spinner spiner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spiner = findViewById(R.id.spinnerFilter);
        String[] filter = getResources().getStringArray(R.array.filters);
        ArrayAdapter adapter =new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,filter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);
    }
    public  void startnewactivty(View v){ Intent intent = new Intent(this, MainActivity.class);
        finish();
    }
    public  void startnewactivty3(View v){ Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }


}