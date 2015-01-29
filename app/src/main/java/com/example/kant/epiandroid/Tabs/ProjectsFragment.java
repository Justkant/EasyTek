package com.example.kant.epiandroid.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Project;
import com.example.kant.epiandroid.EpitechAPI.Projects;
import com.example.kant.epiandroid.MySharedPreferences;
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
public class ProjectsFragment extends Fragment implements ProjectsAdapter.ClickListener {

    private static final String TAG = "ProjectsFragment";

    private List<Project> adapterData = new ArrayList<Project>();
    private ProjectsAdapter mProjectsAdapter;
    private EpitechAPI api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.board_recycler);

        mProjectsAdapter = new ProjectsAdapter(getActivity(), adapterData);
        mProjectsAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mProjectsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        api.projectsGet(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), getString(R.string.empty_string)),
                new Callback<List<Project> >() {
            @Override
            public void success(List<Project> projects, Response response) {
                adapterData.clear();
                adapterData.addAll(projects);
                mProjectsAdapter.notifyDataSetChanged();
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

    }
}
