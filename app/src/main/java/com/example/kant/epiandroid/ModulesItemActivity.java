package com.example.kant.epiandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Module;
import com.example.kant.epiandroid.EpitechAPI.Project;
import com.example.kant.epiandroid.EpitechAPI.ProjectGroup;
import com.example.kant.epiandroid.EpitechAPI.Projects;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ModulesItemActivity extends BaseActivity {

    private static final String TAG = "ModulesItemActivity";

    private Module module = null;
    private EpitechAPI api;

    private int scolaryear = 0;
    private String codemodule = "";
    private String codeinstance = "";
    private String codeacti = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_item);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();
        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);

        api = restAdapter.create(EpitechAPI.class);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        module = (Module) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(R.id.title)).setText(module.title);
        ((TextView) findViewById(R.id.scolaryear)).setText("Year: " + String.valueOf(module.scolaryear));
        ((TextView) findViewById(R.id.date)).setText("Inscription begin at: " + module.date_ins);
        ((TextView) findViewById(R.id.credits)).setText("Credits: " + String.valueOf(module.credits));
        ((TextView) findViewById(R.id.grade)).setText("Grade: " + module.grade);


        if (module != null)
            toolbar.setTitle(module.title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
