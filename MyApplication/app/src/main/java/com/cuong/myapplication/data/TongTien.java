package com.cuong.myapplication.data;

import java.io.Serializable;

public class TongTien implements Serializable {
    private Double tongtien;

    public TongTien(Double tongtien) {
        this.tongtien = tongtien;
    }

    public TongTien() {
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }
}
