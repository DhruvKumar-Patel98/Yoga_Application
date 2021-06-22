package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Navigation_bar extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent homeScreen=new Intent(Navigation_bar.this,MainActivity.class);
                        startActivity(homeScreen);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.nav_yoga_for_beginner:
                        Intent yogaForBeginner=new Intent(Navigation_bar.this,YogaForBeginners.class);
                        startActivity(yogaForBeginner);

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.nav_music:
                        Intent music=new Intent(Navigation_bar.this,RelaxationMusic.class);
                        startActivity(music);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.nav_about:
                        Intent favorite=new Intent(Navigation_bar.this,About.class);
                        startActivity(favorite);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }

                return true;
            }

        });
    }
}