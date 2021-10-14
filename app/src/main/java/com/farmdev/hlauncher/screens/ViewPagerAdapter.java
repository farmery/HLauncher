package com.farmdev.hlauncher.screens;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.farmdev.hlauncher.screens.allapps.AllAppsFragment;
import com.farmdev.hlauncher.screens.home.HomeFragment;

class ViewPagerAdapter extends FragmentStateAdapter {
    ViewPager2 viewPager;
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ViewPager2 viewPager) {
        super(fragmentManager, lifecycle);
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new AllAppsFragment();
        }
            return new HomeFragment(viewPager);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
