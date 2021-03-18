package com.example.safe.model;

public class Users {
    private String hoten , sdt, diachi ;

    public Users(String hoten, String sdt, String diachi) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public Users() {
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
