package com.example.myapplication.AdapterPack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Doituong.SanPham;
import com.example.myapplication.R;

import java.util.ArrayList;


public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.HolderSP> {

    public Context context;
    public ArrayList<SanPham> list = new ArrayList<>();

    public SanPhamAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HolderSP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_rc_view, parent, false);

        return new HolderSP(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSP holder, int position) {

        SanPham sanPham = list.get(position);
    holder.tvTenSp.setText(sanPham.getTenSp());
    holder.tvGiavaSL.setText(sanPham.getGiaSp()+" VNĐ - SL: "+sanPham.getSoLuong());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderSP extends RecyclerView.ViewHolder {
        TextView tvTenSp, tvGiavaSL, tvChinhSua, tvXoa;

        public HolderSP(@NonNull View itemView) {
            super(itemView);
            tvTenSp = itemView.findViewById(R.id.tvTenSP);
            tvGiavaSL = itemView.findViewById(R.id.tvGiavaSL);
            tvChinhSua = itemView.findViewById(R.id.tvChinhSua);
            tvXoa = itemView.findViewById(R.id.tvXoa);


        }
    }

}
