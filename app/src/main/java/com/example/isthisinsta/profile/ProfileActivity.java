package com.example.isthisinsta.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.isthisinsta.BottomNavigationMenu;
import com.example.isthisinsta.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    private final String TAG = "ProfileActivity";
    private final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0, 0);
        setContentView(R.layout.activity_profile);

        setToolBar();
        setBottomNavBar();
    }

    private void setBottomNavBar() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavigationMenu.enableNavigation(this, bottomNavigationView, ACTIVITY_NUM);
    }

    private void setToolBar(){
        Toolbar toolbar = findViewById(R.id.topProfileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_page_menu, menu);
        return true;
    }
}