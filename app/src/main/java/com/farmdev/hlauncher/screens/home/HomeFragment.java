package com.farmdev.hlauncher.screens.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.farmdev.hlauncher.R;

public class HomeFragment extends Fragment {
    ViewPager2 viewPager;
    public HomeFragment(ViewPager2 viewPager){
        this.viewPager = viewPager;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);
        View allAppsButton = viewGroup.findViewById(R.id.all_apps_button);
        allAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1, true);
            }
        });
        return viewGroup;
    }
}
