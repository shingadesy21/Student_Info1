package com.example.studentinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    public static final String mydb = "mydb";

    public Helper(@Nullable Context context) {
        super(context, mydb, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Student(id INTEGER PRIMARY KEY ,NAME TEXT,ROll TEXT,PASS REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String name, String roll, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("ROLLNO", roll);
        contentValues.put("PASSWORD", pass);
        long result = sqLiteDatabase.insert("Student", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean LogInData(String roll,String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM Student WHERE ROLLNO=roll and PASSWORD=pass", null);

            return true;
        }




}
