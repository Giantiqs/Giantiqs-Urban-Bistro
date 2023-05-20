package com.example.test.bistro_database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;
import com.example.test.bistro_classes.bistro_domains.HistoryDomain;
import com.example.test.bistro_classes.bistro_domains.UsersDomain;

import java.util.ArrayList;

public class DBUrbanBistro extends SQLiteOpenHelper {

    static final String db_name = "dBistro";
    static final int ver = 1;

    public DBUrbanBistro(Context context) {
        super(context, db_name, null, ver);
        //context.deleteDatabase("Bistro");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table BistroUsers(userid INTEGER primary key autoincrement, username TEXT, firstname TEXT, middlename TEXT, lastname TEXT, password TEXT, email TEXT, phonenumber TEXT)");
        db.execSQL("create table BistroOrders(orderid INTEGER primary key autoincrement, username TEXT, productname TEXT, quantity INTEGER, date TEXT, time TEXT, fee REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop Table if exists BistroUsers");
        db.execSQL("drop Table if exists BistroOrders");
    }

    public boolean register(String username,
                            String firstname,
                            String middlename,
                            String lastname,
                            String password,
                            String email,
                            String phonenumber){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("username", username);
        v.put("firstname", firstname);
        v.put("middlename", middlename);
        v.put("lastname", lastname);
        v.put("password", password);
        v.put("email", email);
        v.put("phonenumber", phonenumber);

        long results = db.insert("BistroUsers", null, v);

        return results != -1;
    }

    public boolean check_username(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from BistroUsers where username = ?", new String[] {username});

        return c.getCount() > 0;
    }

    public boolean check_user_password(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from BistroUsers where username = ? and password = ?", new String[] {username, password});

        return c.getCount() > 0;
    }

    public boolean update(String username,
                          String firstname,
                          String middlename,
                          String lastname,
                          String password,
                          String email,
                          String phonenumber){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        ArrayList<UsersDomain> usersDomains = get_users();
        String id = getUserId(usersDomains);
        @SuppressLint("Recycle") Cursor c = db.rawQuery("Select * from BistroUsers where username = ?", new String[]{username});

        v.put("username", username);
        v.put("firstname", firstname);
        v.put("middlename", middlename);
        v.put("lastname", lastname);
        v.put("password", password);
        v.put("email", email);
        v.put("phonenumber", phonenumber);

        if (c.getCount() > 0) {
            long results = db.update("BistroUsers", v, "username = ?", new String[]{username});
            return results != -1;
        }
        return false;
    }

    @SuppressLint("Range")
    public ArrayList<UsersDomain> get_users(){

        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from BistroUsers", null);
        ArrayList<UsersDomain> users = new ArrayList<>();

        while (c.moveToNext()) {

            int id = c.getInt(0);
            String username = c.getString(1);
            String firstname = c.getString(2);
            String middlename = c.getString(3);
            String lastname = c.getString(4);
            String password = c.getString(5);
            String email = c.getString(6);
            String phonenumber = c.getString(7);
            UsersDomain this_user = new UsersDomain(id, username, firstname, middlename, lastname, password, email, phonenumber);
            users.add(this_user);
        }

        return users;
    }

    public ArrayList<HistoryDomain> getHistory(String username) {

        String user = UserAdapter.userNow;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<HistoryDomain> arrayList = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from BistroOrders where username = ?", new String[]{user});

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String userName = cursor.getString(1);
            String productName = cursor.getString(2);
            int quantity = cursor.getInt(3);
            String date = cursor.getString(4);
            String time = cursor.getString(5);
            Double fee = cursor.getDouble(6);

            HistoryDomain historyDomain = new HistoryDomain(id, userName, productName, quantity, date, time, fee);
            arrayList.add(historyDomain);
        }

        return arrayList;
    }

    public void insertOrders(String username, String productName, int quantity, String date, String time, Double fee) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("username", username);
        v.put("productname", productName);
        v.put("quantity", quantity);
        v.put("date", date);
        v.put("time", time);
        v.put("fee", fee);

        db.insert("BistroOrders", null, v);
    }

    public String getUserId(ArrayList<UsersDomain> usersDomains) {

        String username = UserAdapter.userNow;
        int index = 0;

        for (int i = 0; i < usersDomains.size(); i++) {
            if (username.equals(usersDomains.get(i).getUsername())) {
                index = i;
                break;
            }
        }

        return String.valueOf(index);
    }

}
