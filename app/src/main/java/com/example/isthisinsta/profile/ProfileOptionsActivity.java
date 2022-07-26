package com.example.isthisinsta.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.isthisinsta.R;

import java.util.ArrayList;

public class ProfileOptionsActivity extends AppCompatActivity {

    private ProfileFragmentAdapter fragmentAdapter;
    private ViewPager2 viewPager;
    private RelativeLayout profileOptionsRelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0,0);
        setContentView(R.layout.activity_profile_options);

        viewPager = findViewById(R.id.profileFragmentsViewPager);
        viewPager.setUserInputEnabled(false);
        profileOptionsRelLayout = findViewById(R.id.profileOptionsRelLayout);

        setTopToolBar();
        setOptions();
        setUpFragments();
    }

    private void setUpFragments(){
        fragmentAdapter = new ProfileFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        fragmentAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        fragmentAdapter.addFragment(new SignOutActivity(), getString(R.string.sign_out));
    }

    private void setUpViewPager(int fragmentNum){
        profileOptionsRelLayout.setVisibility(View.GONE);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(fragmentNum);
    }

    private void setTopToolBar() {
        Toolbar toolbar = findViewById(R.id.topProfileOptionsToolBar);
        setSupportActionBar(toolbar);

        ImageView backButtonImage = findViewById(R.id.profile_options_back_button);
        backButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0,0);
            }
        });
    }

    private void setOptions(){
        ListView profileOptions = findViewById(R.id.profile_options_list);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(ProfileOptionsActivity.this, android.R.layout.simple_list_item_1, options);
        profileOptions.setAdapter(adapter);

        profileOptions.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setUpViewPager(i);
            }
        });
    }
}