package com.example.isthisinsta.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

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

        ProgressBar progressBar = findViewById(R.id.profile_progress_bar);
        progressBar.setVisibility(View.GONE);

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

        ImageView profileMenu = findViewById(R.id.profile_options_menu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProfileOptions = new Intent(ProfileActivity.this, ProfileOptionsActivity.class);
                startActivity(toProfileOptions);
            }
        });
    }


}