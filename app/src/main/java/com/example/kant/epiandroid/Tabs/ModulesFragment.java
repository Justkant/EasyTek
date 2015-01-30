package com.example.kant.epiandroid.Tabs;

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
import com.example.kant.epiandroid.EpitechAPI.Modules;
import com.example.kant.epiandroid.MySharedPreferences;
import com.example.kant.epiandroid.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class ModulesFragment extends Fragment implements ModulesAdapter.ClickListener {

    private static final String TAG = "ModulesFragment";

    private ModulesAdapter mModulesAdapter;
    private Modules mModules = new Modules();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        EpitechAPI api = restAdapter.create(EpitechAPI.class);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.board_recycler);

        mModulesAdapter = new ModulesAdapter(getActivity(), mModules);
        mModulesAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mModulesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setOnScrollListener(((BaseActivity) getActivity()).getRecyclerScrollListener());

        api.modulesGet(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), ""), new Callback<Modules>() {
            @Override
            public void success(Modules modules, Response response) {
                mModules.modules.clear();
                mModules.modules.addAll(modules.modules);
                mModulesAdapter.notifyDataSetChanged();
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
