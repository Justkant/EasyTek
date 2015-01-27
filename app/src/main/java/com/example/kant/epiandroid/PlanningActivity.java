package com.example.kant.epiandroid;

import android.os.Bundle;

public class PlanningActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return PLANNING_ID;
    }
}
