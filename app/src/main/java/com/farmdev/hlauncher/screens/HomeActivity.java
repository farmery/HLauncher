package com.farmdev.hlauncher.screens;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;

import com.farmdev.hlauncher.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

public class HomeActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    View searchBar;
    GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.home_view_pager);
        FragmentManager fm = getSupportFragmentManager();
        Lifecycle lifecycle = getLifecycle();
        viewPagerAdapter = new ViewPagerAdapter(fm, lifecycle, viewPager);

        viewPager.setAdapter(viewPagerAdapter);

        searchBar = findViewById(R.id.app_search_bar);


    }

}
