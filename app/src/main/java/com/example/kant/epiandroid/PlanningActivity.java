package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.kant.epiandroid.Tabs.SlidingTabLayout;
import com.example.kant.epiandroid.Tabs.SlidingTabPagerAdapter;

public class PlanningActivity extends BaseActivity {

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());

        mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mPager.setAdapter(new SlidingTabPagerAdapter(getSupportFragmentManager(), this));
        mTabs.setViewPager(mPager);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return PLANNING_ID;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)).length() == 0) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
