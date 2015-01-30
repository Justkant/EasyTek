package com.example.kant.epiandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Susie;

import java.io.InputStream;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jaccar_a on 30/01/15.
 */
public class SusieItemActivity extends BaseActivity {

    private static final String TAG = "SusiesItemActivity";

    private Susie susie = null;
    private EpitechAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_susie_item);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);

        Toolbar toolbar = getActionBarToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        susie = (Susie) getIntent().getSerializableExtra("item");
        ((TextView) findViewById(R.id.susie_title)).setText(susie.title);
        ((TextView) findViewById(R.id.description)).setText(susie.description);
        ((TextView) findViewById(R.id.date)).setText("Date: " + susie.start.substring(0, susie.start.indexOf(" ")));
        ((TextView) findViewById(R.id.period)).setText("Start at " + susie.start.substring(susie.start.indexOf(" "), susie.start.length()) + " End at " + susie.end.substring(susie.end.indexOf(" "), susie.end.length()));


        api.susieGet(MySharedPreferences.readToPreferences(this, getString(R.string.token_string), getString(R.string.empty_string)), susie.id, susie.id_calendar,
                new Callback<Susie>() {
                    @Override
                    public void success(Susie susies, Response response) {
                        //set nb_place
                        ((TextView) findViewById(R.id.place)).setText("Number of registered: " + susies.logins.length + "/" + susies.nb_place);
                        LinearLayout ll = (LinearLayout) findViewById(R.id.people);

                        if (susies.logins != null) {
                            for (int i = 0; i < susies.logins.length; ++i) {
                                View custom = getLayoutInflater().inflate(R.layout.susie_registered_layout, ll, false);
                                TextView tv = (TextView) custom.findViewById(R.id.name);
                                tv.setText(susies.logins[i].title);
                                new DownloadImageTask((ImageView) custom.findViewById(R.id.img))
                                        .execute(susies.logins[i].picture);

                                ll.addView(custom);
                            }
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });

        if (susie != null)
            toolbar.setTitle(susie.title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
            }
    }

}
