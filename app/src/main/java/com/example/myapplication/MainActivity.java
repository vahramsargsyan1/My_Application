package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText question1,question2,question3,question4,question5;
    Button statistic;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1 = findViewById(R.id.editTextText4);
        question2 = findViewById(R.id.editTextText5);
        question3 = findViewById(R.id.editTextText6);
        question4 = findViewById(R.id.editTextText);
        question5 = findViewById(R.id.editTextText8);
        statistic = findViewById(R.id.button);
        exit = findViewById(R.id.button3);
        String q1 = question1.getText().toString();
        String q2 = question2.getText().toString();
        String q3 = question3.getText().toString();
        String q4 = question4.getText().toString();
        String q5 = question5.getText().toString();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showalert("хотте ли вы выйти из проложения?");
                String q1 = question1.getText().toString();
                String q2 = question2.getText().toString();
                String q3 = question3.getText().toString();
                String q4 = question4.getText().toString();
                String q5 = question5.getText().toString();
            }
        });
    }
    private void showInfo(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
    public  void showalert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход");
        builder.setMessage(text);
        builder.setCancelable(false);
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
            }
        });
        AlertDialog exitdialog = builder.create();
        exitdialog.show();
    }
    public  void startnewactivty(View v){ Intent intent = new Intent(this, MainActivity2.class);
        String q1 = question1.getText().toString();
        String q2 = question2.getText().toString();
        String q3 = question3.getText().toString();
        String q4 = question4.getText().toString();
        String q5 = question5.getText().toString();
        startActivity(intent);
    }

}
