package com.example.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Doituong.Account;

public class NguoiDungDAO {
    private DbHelper dbHelper ;

    public NguoiDungDAO (Context context){
        dbHelper = new DbHelper(context);
    }



    public boolean addNguoiDung (Account account){

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("TENDN",account.getUser());
        values.put("MATKHAU",account.getPassword());


        long kq = sqLiteDatabase.insert("NGUOIDUNG" , null,values);

        return kq > -1;

    }

    public boolean checkTK (String user , String pass){

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE TENDN = ? AND MATKHAU = ?",new String[]{user,pass});

        if (cursor.getCount() > 0){

            return true;

        }else {
            return false;
        }
    }


}
