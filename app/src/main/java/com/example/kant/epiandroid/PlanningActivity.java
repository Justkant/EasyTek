package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kant.epiandroid.Planning.SlidingTabPagerAdapter;
import com.example.kant.epiandroid.Tabs.SlidingTabLayout;

import java.util.Calendar;
import java.util.Date;

public class PlanningActivity extends BaseActivity {

    private ViewPager mPager;
    private Date today;
    private SlidingTabPagerAdapter slidingTabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());

        mPager = (ViewPager) findViewById(R.id.pager);
        SlidingTabLayout mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        slidingTabPagerAdapter = new SlidingTabPagerAdapter(getSupportFragmentManager(), this);
        mPager.setAdapter(slidingTabPagerAdapter);
        mTabs.setViewPager(mPager);
        Calendar cal = Calendar.getInstance();
        today = cal.getTime();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        int i = 0;
        while (i < 7) {
            if (cal.getTime().after(today))
                break;
            i++;
            cal.add(Calendar.DAY_OF_WEEK, 1);
        }
        final int finalI = i - 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPager.setCurrentItem(finalI, true);
            }
        }, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.planning_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.planning_left:
                mPager.setCurrentItem(0, true);
                slidingTabPagerAdapter.prevWeek();
                slidingTabPagerAdapter.notifyDataSetChanged();
                return true;
            case R.id.planning_right:
                mPager.setCurrentItem(0, true);
                slidingTabPagerAdapter.nextWeek();
                slidingTabPagerAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
