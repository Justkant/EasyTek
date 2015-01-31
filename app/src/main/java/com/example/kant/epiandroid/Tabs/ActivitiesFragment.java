package com.example.kant.epiandroid.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.BaseActivity;
import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Projects;
import com.example.kant.epiandroid.MySharedPreferences;
import com.example.kant.epiandroid.ProjectItemActivity;
import com.example.kant.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class ActivitiesFragment extends Fragment implements ActivitiesAdapter.ClickListener {
    private static final String TAG = "Activities Fragment";

    private List<Projects> adapterData = new ArrayList<Projects>();
    private ActivitiesAdapter mActivitiesAdapter;
    private EpitechAPI api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.board_recycler);

        mActivitiesAdapter = new ActivitiesAdapter(getActivity(), adapterData);
        mActivitiesAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mActivitiesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setOnScrollListener(((BaseActivity) getActivity()).getRecyclerScrollListener());

        api.projectsGet(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), getString(R.string.empty_string)),
                new Callback<List<Projects>>() {
                    @Override
                    public void success(List<Projects> projects, Response response) {
                        adapterData.clear();
                        for (int i = 0; i < projects.size(); ++i) {

                            if (!projects.get(i).type_acti.equals("Projet")
                                    && !projects.get(i).type_acti.equals("Projets")
                                    && !projects.get(i).type_acti.equals("Mini-Projets")
                                    && !projects.get(i).type_acti.equals("Soutenance")
                                    && MySharedPreferences.readToPreferences(getActivity(), "location", getString(R.string.empty_string)).equals(projects.get(i).code_location)) {
                                adapterData.add(projects.get(i));
                            }
                        }
                        mActivitiesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });

        return view;
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(getActivity(), ProjectItemActivity.class);
        intent.putExtra("item", adapterData.get(position));
        startActivity(intent);
    }
}
