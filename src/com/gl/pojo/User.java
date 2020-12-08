package com.gl.pojo;

public class User {
    String Userid;
    String password;
    String email;

    public User() {}

    public User(String userid, String password, String email) {
        Userid = userid;
        this.password = password;
        this.email = email;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
