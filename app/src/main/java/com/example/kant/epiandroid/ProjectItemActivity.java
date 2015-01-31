package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Project;
import com.example.kant.epiandroid.EpitechAPI.ProjectGroup;
import com.example.kant.epiandroid.EpitechAPI.Projects;
import com.example.kant.epiandroid.EpitechAPI.Susie;

import java.util.Objects;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jaccar_a on 29/01/15.
 */
public class ProjectItemActivity extends BaseActivity {

    private static final String TAG = "ProjectItemActivity";
    private static final String TAG2 = "ProjectItemActivity2";

    private Projects project = null;
    private EpitechAPI api;

    private String scolaryear;
    private String codemodule;
    private String codeinstance;
    private String codeacti;

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

        project = (Projects) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(R.id.title_module)).setText(project.title_module);
        ((TextView) findViewById(R.id.acti_title)).setText(project.acti_title);


        api.projectGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)), project.scolaryear, project.codemodule, project.codeinstance, project.codeacti,
                new Callback<Project>() {
                    @Override
                    public void success(Project projects, Response response) {
                        scolaryear = projects.scolaryear;
                        codemodule = projects.codemodule;
                        codeinstance = projects.codeinstance;
                        codeacti = projects.codeacti;
                        ((TextView) findViewById(R.id.date)).setText("Begin at " + projects.begin + " and end at " + projects.end);
                        if (projects.end_register != null)
                            ((TextView) findViewById(R.id.registration_limit)).setText("Registration deadline: " + projects.end_register);
                        if (projects.nb_min != 0 && projects.nb_max != 0)
                            ((TextView) findViewById(R.id.group_size)).setText("Size group: " + projects.nb_min + " to " + projects.nb_max);
                        if (projects.instance_location != null)
                            ((TextView) findViewById(R.id.location)).setText("Location: " + projects.instance_location);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });



        ((Button) findViewById(R.id.registration)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                api.projectSub(MySharedPreferences.readToPreferences(getBaseContext(), getString(R.string.token_string), getString(R.string.empty_string)), scolaryear, codemodule, codeinstance, codeacti,
                        new Callback<ProjectGroup>() {
                            @Override

                            public void success(ProjectGroup ret, Response response) {
                                Log.d("ret =====>", "lol");
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Log.d(TAG2, error.getMessage());
                            }
                        });




            }
        });


        if (project != null)
            toolbar.setTitle(project.acti_title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
