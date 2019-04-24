package com.neuedu.entity;

public class User {
    private Integer uid;
    private String uname;
    private String upwd;
    private String telephont;
    private String address;
    private Integer ulevel;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getTelephont() {
        return telephont;
    }

    public void setTelephont(String telephont) {
        this.telephont = telephont;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", telephont='" + telephont + '\'' +
                ", address='" + address + '\'' +
                ", ulevel=" + ulevel +
                '}';
    }
}
