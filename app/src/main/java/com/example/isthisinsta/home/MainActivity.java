package com.example.isthisinsta.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.example.isthisinsta.BottomNavigationMenu;
import com.example.isthisinsta.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private final int ACTIVITY_NUM = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);

        setBottomNavBar();
        setFragments();
    }

    private void setFragments(){
        HomeFragmentsAdapter homeFragmentsAdapter = new HomeFragmentsAdapter(getSupportFragmentManager(),getLifecycle());
        homeFragmentsAdapter.addFragment(new CameraFragment());
        homeFragmentsAdapter.addFragment(new HomeFragment());
        homeFragmentsAdapter.addFragment(new MessagesFragment());

        ViewPager2 viewPager2 = findViewById(R.id.midSectionView);
        viewPager2.setAdapter(homeFragmentsAdapter);

        TabLayout tabLayout = findViewById(R.id.topNavBar);
        new TabLayoutMediator (
                tabLayout,
                viewPager2,
                ((tab, position) ->
                tab.setIcon(R.drawable.ic_camera)
                )
        ).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile_page);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_messages);
    }

    private void setBottomNavBar() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavigationMenu.enableNavigation(this, bottomNavigationView, ACTIVITY_NUM);
    }
}