package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;

import com.example.kant.epiandroid.Tabs.SlidingTabLayout;
import com.example.kant.epiandroid.Tabs.SlidingTabPagerAdapter;


public class BoardActivity extends BaseActivity {

    private int tabId;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        Bundle b = getIntent().getExtras();
        tabId = b.getInt("tabId");

        getActionBarToolbar().setTitle(R.string.title_activity_board);
        setSupportActionBar(getActionBarToolbar());

        mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mPager.setAdapter(new SlidingTabPagerAdapter(getSupportFragmentManager(), this));
        mTabs.setViewPager(mPager);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPager.setCurrentItem(tabId, true);
            }
        }, 100);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return BOARD_ID;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), "").length() == 0) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
