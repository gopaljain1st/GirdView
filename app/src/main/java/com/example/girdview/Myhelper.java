package com.example.girdview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Myhelper extends SQLiteOpenHelper {
    private  static  final  String dbname="CartDb";
    private  static  final int version =1;
    public Myhelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //price real
        String sql="CREATE TABLE PRODUCT(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRODUCT_PRICE TEXT,SELLING_PRICE TEXT,QTY INTEGER)";
        db.execSQL(sql);
        String sql1="CREATE TABLE REGISTRATION(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Gmail TEXT,Phone TEXT,CITY TEXT,ADDRESS TEXT,Password TEXT)";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
