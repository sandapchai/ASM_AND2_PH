package com.example.myapplication.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "asigment2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE NGUOIDUNG (TENDN TEXT PRIMARY KEY, MATKHAU TEXT , HOVATEN TEXT)");

        db.execSQL("CREATE TABLE SANPHAM (MASP INTEGER PRIMARY KEY AUTOINCREMENT , TENSP TEXT ,GIABAN INTEGER , SOLUONG INTEGER)");

        db.execSQL("INSERT INTO SANPHAM VALUES (1,'PIZZA',10000,10)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion!=newVersion){

            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");
            onCreate(db);

        }

    }
}
