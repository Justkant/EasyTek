package com.example.kant.epiandroid.Drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.BoardActivity;
import com.example.kant.epiandroid.MainActivity;
import com.example.kant.epiandroid.PlanningActivity;
import com.example.kant.epiandroid.R;
import com.example.kant.epiandroid.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

public class DrawerFragment extends Fragment {

    private final Class<?>[] classes = {
            MainActivity.class,
            BoardActivity.class,
            PlanningActivity.class,
            SettingsActivity.class};
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.drawer_recycler);

        DrawerAdapter mDrawerAdapter = new DrawerAdapter(getActivity(),
                getDrawerData(getActivity()));
        mDrawerAdapter.setOnClickListener(getActivity());

        mRecyclerView.setAdapter(mDrawerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public static List<DrawerRawInfo> getDrawerData(Context context) {
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

    @Override
    public void itemClicked(View view, int position) {
        mDrawerLayout.closeDrawer(mRecyclerView);
        startActivity(new Intent(getActivity(), classes[position]));
    }
}
