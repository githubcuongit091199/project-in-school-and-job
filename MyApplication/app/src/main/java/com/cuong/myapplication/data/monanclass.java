package com.cuong.myapplication.data;

public class monanclass {

    private  String tenmonan;
    private  String thongtin;
    private  String hinhanh;
    private  double gia;
    private  int id;

    public monanclass(String tenmonan, String thongtin, String hinhanh, double gia,int id) {
        this.tenmonan = tenmonan;
        this.thongtin = thongtin;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.id=id;
    }
    public monanclass(String tenmonan, String hinhanh, double gia) {
        this.tenmonan = tenmonan;
        this.hinhanh = hinhanh;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
