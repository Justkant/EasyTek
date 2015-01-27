package com.example.kant.epiandroid;

import android.os.Bundle;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setupDrawer();

        if (savedInstanceState == null) {
            if (MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)).length() == 0) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new LoginFragment())
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new HomeFragment())
                        .commit();
            }
        }
    }


    @Override
    protected int getSelfNavDrawerItem() {
        return HOME_ID;
    }
}
