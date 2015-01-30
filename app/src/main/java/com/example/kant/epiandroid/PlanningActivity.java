package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kant.epiandroid.Drawer.DrawerAdapter;
import com.example.kant.epiandroid.Planning.PlanningItemAdapter;
import com.example.kant.epiandroid.Planning.PlanningItemData;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PlanningActivity extends BaseActivity implements PlanningItemAdapter.ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        getActionBarToolbar().setTitle(R.string.title_activity_planning);
        setSupportActionBar(getActionBarToolbar());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cal_item_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<PlanningItemData> data = new ArrayList<PlanningItemData>();
        for (int i = 0; i < 10; i++) {
            PlanningItemData newData = new PlanningItemData();
            newData.title = "Title" + i;
            newData.dateStart = new GregorianCalendar(2015, 01, 29, 8 + i, 0);
            newData.dateEnd = new GregorianCalendar(2015, 01, 29, 9 + i, 0);
            newData.description = "Sunday.. Everyday!";

            newData.isFirstOfTheDay = i == 0;

            data.add(newData);
        }

        PlanningItemAdapter adapter = new PlanningItemAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void itemClicked(int position) {
        super.itemClicked(position);
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
