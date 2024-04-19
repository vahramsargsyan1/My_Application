package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.activity.result.contract.ActivityResultContracts;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText question1,question2,question3,question4,question5;
    Button statistic;
    Button exit;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;
    Button btnAdd;
    Button btnRead;
    Button btnClear;

    Button btnLoad;
    public SharedPreferences pref;
    String savedText1;
    String savedText2;
    String savedText3;
    String savedText4;
    String savedText5;
    @SuppressLint("MissingInflatedId")
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
        q1 = question1.getText().toString();
        q2 = question2.getText().toString();
        q3 = question3.getText().toString();
        q4 = question4.getText().toString();
        q5 = question5.getText().toString();
        pref = getSharedPreferences("Table",MODE_PRIVATE);
        savedText1 = pref.getString("a", "null");
        savedText2 = pref.getString("b", "null");
        savedText3 = pref.getString("c", "null");
        savedText4 = pref.getString("d", "null");
        savedText5 = pref.getString("e", "null");

        btnAdd = (Button)findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);
        btnRead = (Button)findViewById(R.id.btnread);
        btnRead.setOnClickListener(this);
        btnClear = (Button)findViewById(R.id.btnclear);
        btnClear.setOnClickListener(this);
        loadText();
        exit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {
                showalert("хотте ли вы выйти из проложения?");

            }


        });
    }
    @Override
    public void onClick(View v) {

    }


    public void onClickadd(View view) {
                saveText();
    }
    public void onClickload(View view) {
                loadText();
    }
    void saveText() {
        pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        ed.putString("a", question1.getText().toString());
        ed.putString("b", question2.getText().toString());
        ed.putString("c", question3.getText().toString());
        ed.putString("d", question4.getText().toString());
        ed.putString("e", question5.getText().toString());
        ed.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        ContentValues contentValues = new ContentValues();
    }

    void loadText() {
        pref = getPreferences(MODE_PRIVATE);
        savedText1 = pref.getString("a", "null");
        savedText2 = pref.getString("b", "null");
        savedText3 = pref.getString("c", "null");
        savedText4 = pref.getString("d", "null");
        savedText5 = pref.getString("e", "null");
        question1.setText(savedText1);
        question2.setText(savedText2);
        question3.setText(savedText3);
        question4.setText(savedText4);
        question5.setText(savedText5);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
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
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
