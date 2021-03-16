package com.cuong.myapplication.data;

public class loginclass {
    private String email;
    private String password;



    private String loaitaikhoan;
    private int mataikhoan;

    public loginclass() {

    }
    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }

    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public loginclass(String email, String password, Integer mataikhoan,String loaitaikhoan) {
        this.email = email;
        this.password = password;
        this.mataikhoan=mataikhoan;
        this.loaitaikhoan=loaitaikhoan;
    }

}
