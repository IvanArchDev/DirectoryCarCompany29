package com.kuroptev.ivan.mobilestore.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.constant.Constant;
import com.kuroptev.ivan.mobilestore.fragments.AlarmAndMedia;
import com.kuroptev.ivan.mobilestore.fragments.AutoChemistry;
//import com.example.ivan.mobilestore.fragments.AutoOfficialDealers;
import com.kuroptev.ivan.mobilestore.fragments.AutoTools;
import com.kuroptev.ivan.mobilestore.fragments.CallAutoExpert;
import com.kuroptev.ivan.mobilestore.fragments.NewsFragment;
//import com.example.ivan.mobilestore.fragments.SharesAndSale;
import com.kuroptev.ivan.mobilestore.fragments.Wheels;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    Wheels wheels;
    Constant constant;
    AutoTools autoTools;
    FragmentManager manager;
//    AutoOfficialDealers dealers;
    AutoChemistry autoChemistry;
    //SharesAndSale sharesAndSale;
    AlarmAndMedia alarmAndMedia;
    CallAutoExpert callAutoExpert;
    NewsFragment news;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPane);
        setSupportActionBar(toolbar);
        news = new NewsFragment();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.clearFocus();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        manager = getSupportFragmentManager();
        autoChemistry = new AutoChemistry();
        autoTools = new AutoTools();
    //    dealers = new AutoOfficialDealers();
        alarmAndMedia = new AlarmAndMedia();
        wheels = new Wheels();
       // sharesAndSale = new SharesAndSale();
        callAutoExpert = new CallAutoExpert();
        startWithFragment(news);
    }

    @Override
    protected void onStop() {
        super.onStop();
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        constant = new Constant();
        int id = item.getItemId();

        if (id == constant.NAV_AUTOCHEMISTRY_ID) {
            moveFragment(autoChemistry, constant.TAG_AUTOCHEMISTRY);
        } else if (id == constant.NAV_AUTOTOOLS_ID) {
            moveFragment(autoTools, constant.TAG_AUTOTOOLS);
        } else if (id == constant.NAV_GASOLINE_ID) {
            moveIntent(Gasoline.class);
/*        } else if (id == constant.NAV_AUTODEALERS_ID) {
            moveFragment(dealers, constant.TAG_AUTODEALERS);*/
        } else if (id == constant.NAV_WHEELS_ID) {
            moveFragment(wheels, constant.TAG_WHEELS);
        } else if (id == constant.NAV_SOUND_ALARM_ID) {
            moveFragment(alarmAndMedia, constant.TAG_SOUND_ALARM);
//        } else if (id == constant.NAV_SHARES_ID){
//            moveFragment(sharesAndSale, constant.TAG_SHARES);
        } else if (id == constant.NAV_NEWS){
            moveFragment(news, constant.TAG_NEWS);
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void moveIntent(Class object){
        Intent intent = new Intent(this, object);
        startActivity(intent);
    }

    private void moveFragment(Fragment fragment, String tag) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.commit();
    }

    private void startWithFragment(Fragment fragment){
        transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }
}
