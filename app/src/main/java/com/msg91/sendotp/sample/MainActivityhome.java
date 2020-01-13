package com.msg91.sendotp.sample;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class MainActivityhome extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        sh=getSharedPreferences("Official",MODE_PRIVATE);
        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.tabChats);
//        tabStatus = findViewById(R.id.tabStatus);
SharedPreferences.Editor e=sh.edit();
e.putBoolean("ph",true);

e.apply();
        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivityhome.this,
                                R.color.green));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivityhome.this,
                               R.color.green));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivityhome.this,
                            R.color.green));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivityhome.this,
                                R.color.green));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;

            }
        }, 2000);
    }

}

