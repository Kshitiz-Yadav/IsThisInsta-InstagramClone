package com.example.isthisinsta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.isthisinsta.create.CreateActivity;
import com.example.isthisinsta.home.MainActivity;
import com.example.isthisinsta.notifications.NotificationsActivity;
import com.example.isthisinsta.profile.ProfileActivity;
import com.example.isthisinsta.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationMenu {
    @SuppressLint("NonConstantResourceId")
    public static void enableNavigation(Context context, BottomNavigationView view,int activityNum){

        Menu menu = view.getMenu();
        MenuItem mItem = menu.getItem(activityNum);
        mItem.setChecked(true);

        view.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.HomePageIcon:
                    Intent homePageintent = new Intent(context, MainActivity.class);
                    context.startActivity(homePageintent);
                    break;
                case R.id.SearchPageIcon:
                    Intent searchPageIntent = new Intent(context, SearchActivity.class);
                    context.startActivity(searchPageIntent);
                    break;
                case R.id.CreatePageIcon:
                    Intent createPageIntent = new Intent(context, CreateActivity.class);
                    context.startActivity(createPageIntent);
                    break;
                case R.id.NotificationsPageIcon:
                    Intent notificationsPageIntent = new Intent(context, NotificationsActivity.class);
                    context.startActivity(notificationsPageIntent);
                    break;
                case R.id.ProfilePageIcon:
                    Intent profilePageIntent = new Intent(context, ProfileActivity.class);
                    context.startActivity(profilePageIntent);
                    break;
            }
            return false;
        });
    }
}
