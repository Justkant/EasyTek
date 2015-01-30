package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.kant.epiandroid.Tabs.SlidingTabLayout;
import com.example.kant.epiandroid.Tabs.SlidingTabPagerAdapter;


public class BoardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);



        Bundle b = getIntent().getExtras();
        int tabId = b.getInt("tabId");

        getActionBarToolbar().setTitle(R.string.title_activity_board);
        setSupportActionBar(getActionBarToolbar());

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mPager.setAdapter(new SlidingTabPagerAdapter(getSupportFragmentManager(), this));
        mTabs.setViewPager(mPager);
        mPager.setCurrentItem(tabId);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return BOARD_ID;
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
