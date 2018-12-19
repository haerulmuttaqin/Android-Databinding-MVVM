package com.example.cpn.mvvmtest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName("berhasil")
    public final int berhasil;


    @Expose
    @SerializedName("email")
    public final String email;


    @Expose
    @SerializedName("password")
    public final int password;

    public User(int berhasil, String email, int password) {
        this.berhasil = berhasil;
        this.email = email;
        this.password = password;
    }
}
