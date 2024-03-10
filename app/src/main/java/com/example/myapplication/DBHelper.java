package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABAZE_VERSION = 1;
    public static final String DATABAZE_NAME = "infoDB";
    public static final String TABLE_ANSWER = "answers";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";

    public DBHelper(Context context) {
        super(context, DATABAZE_NAME,null, DATABAZE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ANSWER + "(" + KEY_ID + "integer primary key," + KEY_NAME + "text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_ANSWER);
        onCreate(db);
    }
}
