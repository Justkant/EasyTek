package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class SlidingTabPagerAdapter extends FragmentStatePagerAdapter {

    private Calendar cal;
    private ArrayList<String> tabs = new ArrayList<String>();
    private ArrayList<String> dates = new ArrayList<String>();

    public SlidingTabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        todayWeek();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PlanningFragment();
        Bundle bundle = new Bundle();
        bundle.putString("planningDate", dates.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    private void makeCalData() {
        tabs.clear();
        dates.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd.MM.yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 0; i < 7; i++) {
            tabs.add(sdf.format(cal.getTime()));
            dates.add(sdf2.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_WEEK, 1);
        }
    }

    public void todayWeek() {
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        makeCalData();
    }

    public void prevWeek() {
        cal.add(Calendar.DAY_OF_WEEK, -14);
        makeCalData();
    }

    public void nextWeek() {
        makeCalData();
    }

    @Override
    public int getItemPosition(Object object) {
        PlanningFragment fragment = (PlanningFragment)object;
        String date = fragment.getDate();
        int position = dates.indexOf(date);

        if (position >= 0) {
            return position;
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}
