package com.example.cpn.mvvmtest;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

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
        if (email.equals(users.getName()) && pass.equals(users.getPass())) {
            mainNav.showLoginResult();
        } else {
            mainNav.handleLoginError();
        }
    }

   public void onLoginClick() {
       Log.d("TAG", "OnLoginClick");
       mainNav.login();
   }

}
