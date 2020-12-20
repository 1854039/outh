package com.example.userservice.pojo;

public class User {
    private String user_Name;
    private String user_Pwd;
    private int user_ID;
    private int user_token;
    private  int user_state;

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Pwd() {
        return user_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        this.user_Pwd = user_Pwd;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getUser_token() {
        return user_token;
    }

    public void setUser_token(int user_token) {
        this.user_token = user_token;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }
}
