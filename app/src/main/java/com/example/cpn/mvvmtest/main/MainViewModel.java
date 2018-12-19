package com.example.cpn.mvvmtest.main;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.cpn.mvvmtest.User;
import com.example.cpn.mvvmtest.api.ApiClient;
import com.example.cpn.mvvmtest.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MainNav mainNav;
    private ApiInterface apiInterface;

    MainViewModel(MainNav mainNav) {
        this.mainNav = mainNav;
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    }

    public void login(String email, String pass) {

        Call<User> userCall = apiInterface.loginUser(email, pass);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                Log.d("RESPONSE", response.message());
                assert response.body() != null;
                if (response.body().berhasil == 1) {
                    mainNav.showLoginResult();
                } else mainNav.handleLoginError();
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                mainNav.handleLoginError();
            }
        });
    }

   public void onLoginClick() {
       Log.d("TAG1", "OnLoginClick");
       mainNav.login();
   }

}
