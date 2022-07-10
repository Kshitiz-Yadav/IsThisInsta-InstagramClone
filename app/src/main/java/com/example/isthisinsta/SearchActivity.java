package com.example.isthisinsta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {
    private final String TAG = "SearchActivity";
    private final int ACTIVITY_NUM = 1;

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