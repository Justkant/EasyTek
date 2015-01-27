package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.HomeInfos;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HomeActivity extends BaseActivity {

    private HomeInfos mHomeInfos;
    private EpitechAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        if (savedInstanceState == null) {
            if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)).length() == 0) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        }

        api.infosPost(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)), new Callback<HomeInfos>() {
            @Override
            public void success(HomeInfos homeInfos, Response response) {
                mHomeInfos = homeInfos;
                //mHomeInfos.getInfos().getLogin();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return HOME_ID;
    }
}
