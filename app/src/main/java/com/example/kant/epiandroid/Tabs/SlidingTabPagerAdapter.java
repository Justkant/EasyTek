package com.example.kant.epiandroid.Tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kant.epiandroid.BoardFragment;
import com.example.kant.epiandroid.R;

/**
 * Created by Quentin on 23/01/2015.
 */
public class SlidingTabPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;

    public SlidingTabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        BoardFragment boardFragment = BoardFragment.getInstance(position);
        return boardFragment;
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
