package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.AdapterPack.SanPhamAdapter;
import com.example.myapplication.DataBase.SanPhamDAO;
import com.example.myapplication.Doituong.SanPham;

import java.util.ArrayList;

public class TestDB extends AppCompatActivity {
    ArrayList<SanPham> list = new ArrayList<>();
    SanPhamDAO sanPhamDAO = new SanPhamDAO(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);

        list = sanPhamDAO.getALLSP();

        RecyclerView recyclerView = findViewById(R.id.recycleView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        SanPhamAdapter adapter = new SanPhamAdapter(this,list);
        recyclerView.setAdapter(adapter);




    }
}