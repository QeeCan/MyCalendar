package com.qeecan.mycalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qeecan.mycalendar.adapter.MyViewPagerAdapter;
import com.qeecan.mycalendar.fragment.ConsFragment;
import com.qeecan.mycalendar.fragment.OldsFragment;
import com.qeecan.mycalendar.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<Fragment>fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        viewPager2 = findViewById(R.id.vp2);
        bottomNavigationView=findViewById(R.id.nav_more);
        initData();

        myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager2.setAdapter(myViewPagerAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.item_old:
                        viewPager2.setCurrentItem(0);
                        break;

                    case R.id.item_weather:
                        viewPager2.setCurrentItem(1);
                        break;

                    case R.id.item_cons:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }

        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.item_old);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.item_weather);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.item_cons);
                        break;
                }
            }
        });


    }

    private void initData() {
        fragments=new ArrayList<>();
        OldsFragment oldsFragment = OldsFragment.newInstance("黄历","");
        WeatherFragment weatherFragment = WeatherFragment.newInstance("天气","");
        ConsFragment consFragment = ConsFragment.newInstance("星座","");

        fragments.add(oldsFragment);
        fragments.add(weatherFragment);
        fragments.add(consFragment);

    }
}