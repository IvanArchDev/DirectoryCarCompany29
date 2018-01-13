package com.kuroptev.ivan.mobilestore.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.adapters.ViewPagerAdapter;
import com.kuroptev.ivan.mobilestore.fragments.Fuel92;
import com.kuroptev.ivan.mobilestore.fragments.Fuel95;
import com.kuroptev.ivan.mobilestore.fragments.Fuel98;
import com.kuroptev.ivan.mobilestore.fragments.FuelDT;

public class Gasoline extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasoline);

        toolbar = (Toolbar) findViewById(R.id.toolbar_gas);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_fuel);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager pager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fuel92(), "92");
        adapter.addFragment(new Fuel95(), "95");
        adapter.addFragment(new Fuel98(), "98");
        adapter.addFragment(new FuelDT(), "DT");
        pager.setAdapter(adapter);
    }
}
