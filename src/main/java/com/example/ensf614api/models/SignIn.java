package com.example.ensf614api.models;

public class SignIn {
    private String userID;
    private String password;

    public void setUserID(String userID){this.userID = userID;}
    public String getUserId(){return this.userID;}
    public void setPassword(String password){this.password = password;}
    public String getPassword(){return this.password;}
}
