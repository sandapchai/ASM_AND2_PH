package com.example.myapplication.FragmentPack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.AdapterPack.SanPhamAdapter;
import com.example.myapplication.DataBase.DbHelper;
import com.example.myapplication.DataBase.SanPhamDAO;
import com.example.myapplication.Doituong.SanPham;
import com.example.myapplication.R;
import com.example.myapplication.TrangChu;

import java.util.ArrayList;

public class QuanLiSanPhamFragment extends Fragment {


    private SanPhamDAO sanPhamDAO ;
    private RecyclerView recyclerView;

    private Button btnThem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quanlisanpham, container, false);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sanPhamDAO = new SanPhamDAO(getContext());

        recyclerView = view.findViewById(R.id.rcSanPham);
        btnThem = view.findViewById(R.id.btnAddSanPham);

        ArrayList<SanPham> list = sanPhamDAO.getALLSP();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        SanPhamAdapter adapter = new SanPhamAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

    }
}
