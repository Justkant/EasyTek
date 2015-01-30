package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Message;

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
public class NotifActivity extends BaseActivity implements NotifsAdapter.ClickListener {

    private List<Message> mMessages = new ArrayList<Message>();
    private NotifsAdapter mNotifsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        EpitechAPI api = restAdapter.create(EpitechAPI.class);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(R.string.title_activity_notif);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.notif_recycler);

        mNotifsAdapter = new NotifsAdapter(this, mMessages);
        mNotifsAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mNotifsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        api.messagesGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)), new Callback<List<Message>>() {
            @Override
            public void success(List<Message> messages, Response response) {
                mMessages.clear();
                mMessages.addAll(messages);
                mNotifsAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

                if (error.getMessage().equals("403 FORBIDDEN")) {
                    backToLogin();
                }

                Toast toast = Toast.makeText(getBaseContext(), "Failed to load data", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }

    @Override
    public void itemClicked(int position) {
    }

    private void backToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
