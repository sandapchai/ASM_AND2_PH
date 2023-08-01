package com.example.myapplication.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Doituong.SanPham;

import java.util.ArrayList;

public class SanPhamDAO {

    private DbHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);

    }


    public ArrayList<SanPham> getALLSP() {

        ArrayList<SanPham> list = new ArrayList<>();
        list.clear();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM", null);


        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            do {
                int ma = cursor.getInt(0),
                        gia = cursor.getInt(2),
                        sl = cursor.getInt(3);
                String ten = cursor.getString(1);

                list.add(new SanPham(ma, ten, gia, sl));

                cursor.moveToNext();
            } while (!cursor.isAfterLast());

        }


        return list;
    }

}
