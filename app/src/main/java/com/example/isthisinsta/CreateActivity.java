package com.example.isthisinsta;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateActivity extends AppCompatActivity {
    private final String TAG = "CreateActivity";
    private final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);

        setBottomNavBar();

    }

    private void setBottomNavBar() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavigationMenu.enableNavigation(this, bottomNavigationView, ACTIVITY_NUM);
    }
}