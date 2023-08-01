package com.example.myapplication.Doituong;

public class SanPham {
    int maSp , giaSp , soLuong;

    String tenSp;

    public SanPham(int maSp,String tenSp, int giaSp, int soLuong ) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.soLuong = soLuong;

    }
    public SanPham(String tenSp, int giaSp, int soLuong ) {
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.soLuong = soLuong;

    }


    public int getMaSp() {
        return maSp;
    }

    public int getGiaSp() {
        return giaSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }
}
