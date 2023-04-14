package com.example.practice_3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.practice_3.R;
import com.example.practice_3.ui.LoginFragment;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragm = getSupportFragmentManager().beginTransaction();
        loginFragment = new LoginFragment();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_graph);
        /*NavController navController = navHostFragment.getNavController();*/
    }
}
