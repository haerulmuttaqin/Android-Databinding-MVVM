package com.example.cpn.mvvmtest.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private MainNav mainNav;

    MainViewModelFactory(MainNav mainNav) {
        this.mainNav = mainNav;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(mainNav);
    }
}
