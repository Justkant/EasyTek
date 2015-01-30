package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.kant.epiandroid.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class SlidingTabPagerAdapter extends FragmentPagerAdapter {

    private Calendar cal;
    private String[] tabs = new String[7];
    private String[] dates = new String[7];

    public SlidingTabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd.MM.yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 7; i++) {
            tabs[i] = sdf.format(cal.getTime());
            dates[i] = sdf2.format(cal.getTime());
            cal.add(Calendar.DAY_OF_WEEK, 1);
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PlanningFragment();
        Bundle bundle = new Bundle();
        bundle.putString("planningDate", dates[position]);
        fragment.setArguments(bundle);
        return fragment;
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
