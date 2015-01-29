package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        getActionBarToolbar().setTitle(R.string.title_activity_main);
        setSupportActionBar(getActionBarToolbar());

        api.infosGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)), new Callback<HomeInfos>() {
            @Override
            public void success(HomeInfos homeInfos, Response response) {
                mHomeInfos = homeInfos;
                setTextHome();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                mHomeInfos = null;
            }
        });

        int[] buttonIdTab = {
                R.id.modules_button,
                R.id.activities_button,
                R.id.projects_button,
                R.id.susies_button,
                R.id.marks_button
        };

        for (int i = 0; i < buttonIdTab.length; i++) {
            Button button = (Button) findViewById(buttonIdTab[i]);
            final int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToNavDrawerItem(BOARD_ID, finalI);
                }
            });
        }

    }

    private void setTextHome() {
        TextView text = (TextView) findViewById(R.id.home_text);
        text.setText(mHomeInfos.infos.firstname + " " + mHomeInfos.infos.lastname);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return HOME_ID;
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
