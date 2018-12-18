package com.example.cpn.mvvmtest;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.cpn.mvvmtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainNav {

    MainViewModel mainViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this, new MainViewModelFactory(this)).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
    }

    @Override
    public void handleLoginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        mainViewModel.login(binding.email.getText().toString(), binding.pass.getText().toString());
    }

    @Override
    public void showLoginResult() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}
