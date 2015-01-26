package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.HomeInfos;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 20/01/2015.
 */

public class HomeFragment extends Fragment {

    private HomeInfos mHomeInfos;
    private EpitechAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        api.infosPost(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), getString(R.string.empty_string)), new Callback<HomeInfos>() {
            @Override
            public void success(HomeInfos homeInfos, Response response) {
                mHomeInfos = homeInfos;
                //mHomeInfos.getInfos().getLogin();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
        return view;
    }
}
