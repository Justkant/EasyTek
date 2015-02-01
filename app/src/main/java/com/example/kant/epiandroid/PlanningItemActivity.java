package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kant.epiandroid.BaseActivity;
import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Event;
import com.example.kant.epiandroid.EpitechAPI.Planning;
import com.example.kant.epiandroid.MySharedPreferences;
import com.example.kant.epiandroid.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 01/02/2015.
 * EpiAndroid Project.
 */
public class PlanningItemActivity extends BaseActivity {

    private static final String TAG = "PlanningItemActivity";

    private Planning planning = null;
    private EpitechAPI api;

    private String scolaryear;
    private String codemodule;
    private String codeinstance;
    private String codeacti;
    private String codeevent;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_item);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        planning = (Planning) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(R.id.title_module)).setText(planning.titlemodule);
        ((TextView) findViewById(R.id.acti_title)).setText(planning.acti_title);

        final Button token_button = (Button) findViewById(R.id.token_button);
        registration = (Button) findViewById(R.id.registration);

        token_button.setEnabled(planning.allow_token);
        registration.setEnabled(planning.allow_register);

        if (planning.event_registered != null && planning.event_registered)
            registration.setText("Unregister");

        api.eventGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), ""),
                planning.scolaryear, planning.codemodule, planning.codeinstance, planning.codeacti, planning.codeevent,
                new Callback<Event>() {
                    @Override
                    public void success(Event event, Response response) {
                        scolaryear = event.scolaryear;
                        codemodule = event.codemodule;
                        codeinstance = event.codeinstance;
                        codeacti = event.codeacti;
                        codeevent = event.codeevent;
                        ((TextView) findViewById(R.id.date)).setText("Begin at " + event.begin + " and end at " + event.end);
                        ((TextView) findViewById(R.id.group_size)).setText("Number of groups : " + event.nb_group +
                                "\nNumber of registered students" + event.nb_registered);
                        ((TextView) findViewById(R.id.location)).setText("Location: " + event.instance_location);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registration.getText().equals("Register")) {
                    api.eventSub(MySharedPreferences.readToPreferences(getBaseContext(), getString(R.string.token_string), ""),
                            scolaryear, codemodule, codeinstance, codeacti, codeevent,
                            new Callback<Object>() {
                                @Override

                                public void success(Object ret, Response response) {
                                    registration.setText("Unregister");
                                    Log.i(TAG, Integer.toString(response.getStatus()));
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    Log.i(TAG, error.getMessage());
                                }
                            });
                }
                else {
                    api.eventSub(MySharedPreferences.readToPreferences(getBaseContext(), getString(R.string.token_string), ""),
                            scolaryear, codemodule, codeinstance, codeacti, codeevent,
                            new Callback<Object>() {
                                @Override

                                public void success(Object ret, Response response) {
                                    registration.setText("Register");
                                    Log.i(TAG, Integer.toString(response.getStatus()));
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    Log.i(TAG, error.getMessage());
                                }
                            });
                }
            }
        });

        token_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView token_text = (TextView) findViewById(R.id.token_textview);
                api.tokenValidation(MySharedPreferences.readToPreferences(getBaseContext(), getString(R.string.token_string), ""),
                        scolaryear, codemodule, codeinstance, codeacti, codeevent, token_text.getText().toString(),
                        new Callback<String>() {
                            @Override
                            public void success(String ret, Response response) {
                                token_button.setEnabled(false);
                                Log.i(TAG, Integer.toString(response.getStatus()));
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.i(TAG, error.getMessage());
                            }
                        });
            }
        });

        if (planning != null)
            toolbar.setTitle(planning.acti_title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
