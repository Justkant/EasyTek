package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kant.epiandroid.R;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class SlidingTabPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public SlidingTabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabs = context.getResources().getStringArray(R.array.planning_week);
    }

    @Override
    public Fragment getItem(int position) {
        return new PlanningFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
