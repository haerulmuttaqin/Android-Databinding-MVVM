package com.example.cpn.mvvmtest.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.cpn.mvvmtest.R;
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
    public void showLoading() {
        binding.loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void login() {
        mainViewModel.login(
                binding.email.getText().toString(),
                binding.password.getText().toString()
        );
    }

    @Override
    public void hideLoading() {
        binding.loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
