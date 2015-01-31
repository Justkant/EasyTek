package com.example.kant.epiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.HomeInfos;
import com.example.kant.epiandroid.EpitechAPI.Photo;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "Home Activity";
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
            if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), "").length() == 0) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return;
            }
        }

        getActionBarToolbar().setTitle(R.string.title_activity_main);
        setSupportActionBar(getActionBarToolbar());
        api.infosGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), ""), new Callback<HomeInfos>() {
            @Override
            public void success(HomeInfos homeInfos, Response response) {
                mHomeInfos = homeInfos;
                saveUserPreferences();
                getPhoto();
                MySharedPreferences.saveToPreferences(getBaseContext(), "location", mHomeInfos.infos.location.substring(mHomeInfos.infos.location.indexOf("/") + 1, mHomeInfos.infos.location.length()));
            }

            @Override
            public void failure(RetrofitError error) {
                mHomeInfos = null;
                if (error.getMessage().equals("403 FORBIDDEN")) {
                    backToLogin();
                }
                Toast toast = Toast.makeText(getBaseContext(), "Failed to load data", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        int[] buttonIdTab = {
                R.id.modules_button,
                R.id.activities_button,
                R.id.projects_button,
                R.id.susies_button,
                R.id.marks_button,
                R.id.trombi_button
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

    private void getPhoto() {
        if (mMemoryCache.get("userPicture") == null) {
            api.photoGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), ""), mHomeInfos.infos.login, new Callback<Photo>() {
                @Override
                public void success(Photo photo, Response response) {
                    MySharedPreferences.saveToPreferences(getBaseContext(), "userPhoto", photo.url);
                    updateUserPhoto();
                }

                @Override
                public void failure(RetrofitError error) {
                    if (error.getMessage().equals("403 FORBIDDEN")) {
                        backToLogin();
                    }
                }
            });
            setImageProfileClickListener(mHomeInfos.infos.login);
        }
    }

    private void backToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void saveUserPreferences() {
        MySharedPreferences.saveToPreferences(getBaseContext(), "hasUserInfos", "y");
        MySharedPreferences.saveToPreferences(getBaseContext(), "userName", mHomeInfos.infos.firstname + " " + mHomeInfos.infos.lastname);
        MySharedPreferences.saveToPreferences(getBaseContext(), "userLogin", mHomeInfos.infos.login);
        MySharedPreferences.saveToPreferences(getBaseContext(), "userLogtime",
                "Log time : " + mHomeInfos.current.active_log.substring(0, mHomeInfos.current.active_log.indexOf('.')) + "h");
        updateUserInfos();
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return HOME_ID;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notif_icon:
                startActivity(new Intent(this, NotifActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), "").length() == 0) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
