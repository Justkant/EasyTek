package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kant.epiandroid.Planning.PlanningDayAdapter;
import com.example.kant.epiandroid.Planning.PlanningDayData;

import java.util.ArrayList;

public class PlanningActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cal_day_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<PlanningDayData> data = new ArrayList<PlanningDayData>();
        for (int i = 0; i < 10; i++)
        {
            PlanningDayData newData = new PlanningDayData();
            newData.dateNb = "" + i;
            newData.dateDay = "Dim";
            data.add(newData);
        }

        PlanningDayAdapter adapter = new PlanningDayAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return PLANNING_ID;
    }
}
