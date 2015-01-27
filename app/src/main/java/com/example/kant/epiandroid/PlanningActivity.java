package com.example.kant.epiandroid;

import android.os.Bundle;

public class PlanningActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return PLANNING_ID;
    }
}
