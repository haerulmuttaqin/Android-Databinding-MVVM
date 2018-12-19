package com.example.cpn.mvvmtest.api;

import com.example.cpn.mvvmtest.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("hjci/login_user.php")
    Call<User> loginUser(@Field("email") String email, @Field("password") String password);
}
