package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Project;

/**
 * Created by jaccar_a on 29/01/15.
 */
public class ProjectItemActivity extends BaseActivity {

    private Project project = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_item);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        project = (Project) getIntent().getSerializableExtra("item");

        ((TextView) findViewById(R.id.codemodule)).setText(project.codemodule);
        ((TextView) findViewById(R.id.title_module)).setText(project.title_module);
        ((TextView) findViewById(R.id.project)).setText(project.project);
        ((TextView) findViewById(R.id.acti_title)).setText(project.acti_title);


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
