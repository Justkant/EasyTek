package com.example.kant.epiandroid;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.LruCache;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kant.epiandroid.Drawer.DrawerAdapter;
import com.example.kant.epiandroid.Drawer.DrawerRawInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 23/01/2015.
 * EpiAndroid Project.
 */

public class BaseActivity extends ActionBarActivity implements DrawerAdapter.ClickListener {

    protected static final int HOME_ID = 0;
    protected static final int BOARD_ID = 1;
    protected static final int PLANNING_ID = 2;
    protected static final int SETTINGS_ID = 3;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar toolbar;
    private Handler mHandler;
    private LruCache<String, Bitmap> mMemoryCache;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mMemoryCache = ((MyApplication) getApplication()).mMemoryCache;
    }

    protected void setupDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout == null) {
            return;
        }

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, 0, 0);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });

        profileImage = (ImageView) findViewById(R.id.profile_image);
        updateUserInfos();
        setImageProfileClickListener(MySharedPreferences.readToPreferences(this, "userLogin", ""));
        if (mMemoryCache.get("userPicture") != null)
            profileImage.setImageBitmap(mMemoryCache.get("userPicture"));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.drawer_recycler);

        DrawerAdapter mDrawerAdapter = new DrawerAdapter(this,
                getDrawerData(this));
        mDrawerAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mDrawerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void setImageProfileClickListener(final String login) {
        if (login.length() == 0)
            return;
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity(login);
            }
        });

    }

    private void startProfileActivity(String login) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("profileLogin", login);
        startActivity(intent);
    }

    protected void updateUserPhoto() {
        if (mMemoryCache.get("userPicture") == null && MySharedPreferences.readToPreferences(this, "userPhoto", "").length() > 0) {
            new MyImageLoader(mMemoryCache, (ImageView) findViewById(R.id.profile_image))
                    .execute(MySharedPreferences.readToPreferences(this, "userPhoto", ""));
        }
    }

    protected void updateUserInfos() {
        if (MySharedPreferences.readToPreferences(this, "hasUserInfos", "").equals("y")) {
            TextView usernametext = (TextView) findViewById(R.id.usernameText);
            usernametext.setText(MySharedPreferences.readToPreferences(this, "userName",
                    getString(R.string.username_textview)));

            TextView logintext = (TextView) findViewById(R.id.loginText);
            logintext.setText(MySharedPreferences.readToPreferences(this, "userLogtime", "Log time : 0h") + "\n" +
                    MySharedPreferences.readToPreferences(this, "userLogin", "login"));
        }
    }

    private static List<DrawerRawInfo> getDrawerData(Context context) {
        List<DrawerRawInfo> data = new ArrayList<>();

        int[] icons = {
                R.drawable.ic_home_grey,
                R.drawable.ic_assignment_grey,
                R.drawable.ic_event_grey,
                R.drawable.ic_settings_grey};
        String[] titles = context.getResources().getStringArray(R.array.drawer_strings);

        for (int i = 0; i < titles.length && i < icons.length; i++) {
            DrawerRawInfo current = new DrawerRawInfo();
            current.title = titles[i];
            current.iconId = icons[i];
            data.add(current);
        }
        return data;
    }

    protected boolean isNavDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    protected void closeNavDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(Gravity.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }

    protected Toolbar getActionBarToolbar() {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(R.id.actionBarToolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
        }
        return toolbar;
    }

    protected int getSelfNavDrawerItem() {
        return 0;
    }

    @Override
    public void itemClicked(final int position) {
        if (position == getSelfNavDrawerItem()) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return;
        }

        if (isSpecialItem(position)) {
            goToNavDrawerItem(position, 0);
        } else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToNavDrawerItem(position, 0);
                }
            }, 250);
            setSelectedNavDrawerItem(position);
        }

        mDrawerLayout.closeDrawer(Gravity.START);
    }

    // TODO: implement function
    private void setSelectedNavDrawerItem(int position) {
    }

    protected void goToNavDrawerItem(int position, final int tabId) {
        Intent intent;
        switch (position) {
            case HOME_ID:
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;
            case BOARD_ID:
                intent = new Intent(this, BoardActivity.class);
                intent.putExtra("tabId", tabId);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;
            case PLANNING_ID:
                intent = new Intent(this, PlanningActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;
            case SETTINGS_ID:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
    }

    private boolean isSpecialItem(int position) {
        return position == SETTINGS_ID;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupDrawer();
    }
}
