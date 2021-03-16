package com.cuong.myapplication.data;

import java.io.Serializable;

public class Gio implements Serializable {

    private int idma;
    private String tenma;
    private Double giama;
    private String hinhma;
    private int soluong;





    public Gio(int idma, String tenma, Double giama, String hinhma, int soluong) {
        this.idma = idma;
        this.tenma = tenma;
        this.giama = giama;
        this.hinhma = hinhma;
        this.soluong = soluong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }




    public Gio(String tenma, Double giama, String hinhma) {
        this.tenma = tenma;
        this.giama = giama;
        this.hinhma = hinhma;
    }




    public int getIdma() {
        return idma;
    }

    public void setIdma(int idma) {
        this.idma = idma;
    }

    public String getTenma() {
        return tenma;
    }

    public void setTenma(String tenma) {
        this.tenma = tenma;
    }

    public Double getGiama() {
        return giama;
    }

    public void setGiama(Double giama) {
        this.giama = giama;
    }

    public String getHinhma() {
        return hinhma;
    }

    public void setHinhma(String hinhma) {
        this.hinhma = hinhma;
    }

}
