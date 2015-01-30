package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Infos;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class ProfileActivity extends BaseActivity {
    private String profileLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        profileLogin = bundle.getString("profileLogin");

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        EpitechAPI api = restAdapter.create(EpitechAPI.class);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle(R.string.title_activity_profile);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        api.userGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)),
                profileLogin, new Callback<Infos>() {
                    @Override
                    public void success(Infos infos, Response response) {
                        setupProfileData(infos);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                        if (error.getMessage().equals("403 FORBIDDEN")) {
                            onBackPressed();
                        }

                        Toast toast = Toast.makeText(getBaseContext(), "Failed to load data", Toast.LENGTH_SHORT);
                        toast.show();

                    }
                });
    }

    private void setupProfileData(Infos infos) {
        TextView textView = (TextView) findViewById(R.id.Grades);
        if (infos.gpa.size() > 0)
            textView.setText("GPA : " + infos.gpa.get(0).gpa);
    }
}
