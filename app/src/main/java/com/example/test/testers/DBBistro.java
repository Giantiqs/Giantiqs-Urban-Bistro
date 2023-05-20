package com.example.test.testers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBBistro extends SQLiteOpenHelper {

    public DBBistro(Context context) {

        super(context, "Login", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int x, int y){

        db.execSQL("drop Table if exists users");
    }

    public boolean insert(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();

        content_values.put("username", username);
        content_values.put("password", password);

        long results = db.insert("users", null, content_values);

        return results != -1;
    }

    public boolean check_username(String username){

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from users where username = ?", new String[] {username});

        return c.getCount() > 0;
    }

    public boolean check_user_password(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});

        return c.getCount() > 0;
    }

    public void delete_all(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from users");
    }
}
