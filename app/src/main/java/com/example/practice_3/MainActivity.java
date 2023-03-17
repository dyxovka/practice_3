package com.example.practice_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

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
