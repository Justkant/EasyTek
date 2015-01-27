package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.kant.epiandroid.Tabs.SlidingTabLayout;
import com.example.kant.epiandroid.Tabs.SlidingTabPagerAdapter;


public class BoardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mPager.setAdapter(new SlidingTabPagerAdapter(getSupportFragmentManager(), this));
        mTabs.setViewPager(mPager);
    }


    @Override
    protected int getSelfNavDrawerItem() {
        return BOARD_ID;
    }
}
