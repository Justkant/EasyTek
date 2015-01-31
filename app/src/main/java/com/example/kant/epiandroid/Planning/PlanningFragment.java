package com.example.kant.epiandroid.Planning;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.BaseActivity;
import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Planning;
import com.example.kant.epiandroid.MySharedPreferences;
import com.example.kant.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class PlanningFragment extends Fragment implements PlanningAdapter.ClickListener {

    private EpitechAPI api;
    private List<Planning> planning = new ArrayList<Planning>();
    private PlanningAdapter mPlanningAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        String planningDate = getArguments().getString("planningDate");

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.board_recycler);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        mPlanningAdapter = new PlanningAdapter(getActivity(), planning);
        mPlanningAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mPlanningAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setOnScrollListener(((BaseActivity) getActivity()).getRecyclerScrollListener());

        api.planningGet(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), ""), planningDate, planningDate, new Callback<List<Planning>>() {
            @Override
            public void success(List<Planning> plannings, Response response) {
                planning.clear();
                planning.addAll(plannings);
                mPlanningAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        return view;
    }

    @Override
    public void itemClicked(int position) {

    }
}
