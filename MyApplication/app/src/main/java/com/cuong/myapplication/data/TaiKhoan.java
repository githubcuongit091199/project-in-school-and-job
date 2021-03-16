package com.cuong.myapplication.data;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private int mataikhoan;
    private String taikhoan;

    public TaiKhoan(String taikhoan) {
        this.taikhoan=taikhoan;

    }

    public TaiKhoan() {

    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public TaiKhoan(int mataikhoan,String taikhoan) {
        this.mataikhoan=mataikhoan;
        this.taikhoan = taikhoan;

    }



    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }


}
