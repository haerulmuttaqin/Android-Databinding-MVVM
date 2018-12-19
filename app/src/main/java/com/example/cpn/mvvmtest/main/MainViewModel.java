package com.example.cpn.mvvmtest.main;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.cpn.mvvmtest.User;

public class MainViewModel extends ViewModel {

    private User users;
    private MainNav mainNav;

    public MainViewModel(MainNav mainNav) {
        this.mainNav = mainNav;
        if (users == null) {
            loadUsers();
        }
    }

    public User getUsers() {
        if (users == null) {
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        users =  new User("test", "test");
    }

    public void login(String email, String pass) {
        Log.d("TAG2", "Click");
        if (email.equals(users.getEmail()) && pass.equals(users.getPassword())) {
            mainNav.showLoginResult();
        } else {
            mainNav.handleLoginError();
        }
    }

   public void onLoginClick() {
       Log.d("TAG1", "OnLoginClick");
       mainNav.login();
   }

}
