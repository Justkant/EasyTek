package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class PlanningActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cal_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CalendarData> data = new ArrayList<CalendarData>();
        for (int i = 0; i < 10; i++)
        {
            CalendarData newData = new CalendarData();
            newData.title = "title" + i;
            newData.time = "8:00 - 9:00";
            newData.description = "Quentin est un énorme pd";
            data.add(newData);
        }

        ArrayList<CalendarData> removedData = new ArrayList<CalendarData>();

        CalendarAdapter adapter = new CalendarAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return PLANNING_ID;
    }
}
