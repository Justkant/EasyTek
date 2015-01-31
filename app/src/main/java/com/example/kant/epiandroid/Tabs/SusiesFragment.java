package com.example.kant.epiandroid.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kant.epiandroid.BaseActivity;
import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Susie;
import com.example.kant.epiandroid.MySharedPreferences;
import com.example.kant.epiandroid.R;
import com.example.kant.epiandroid.SusieItemActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class SusiesFragment extends Fragment implements SusiesAdapter.ClickListener {

    private static final String TAG = "SusiesFragment";
    private String TYPE = "all";

    private List<Susie> adapterData = new ArrayList<>();
    private SusiesAdapter mSusiesAdapter;
    private EpitechAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_board, container, false);
        setHasOptionsMenu(true);

        view.findViewById(R.id.susie_visual).setVisibility(View.VISIBLE);
        view.findViewById(R.id.valid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest(view, ((EditText) view.findViewById(R.id.start_date)).getText().toString(), ((EditText) view.findViewById(R.id.end_date)).getText().toString(), TYPE);
            }
        });
        view.findViewById(R.id.test).setVisibility(View.VISIBLE);


        sendRequest(view, "2015/02/06", "2015/02/06", TYPE);

        return view;
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(getActivity(), SusieItemActivity.class);
        intent.putExtra("item", adapterData.get(position));
        startActivity(intent);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    public void sendRequest(View v, String start, String end, String type) {
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.board_recycler);

        mSusiesAdapter = new SusiesAdapter(getActivity(), adapterData);
        mSusiesAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mSusiesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setOnScrollListener(((BaseActivity) getActivity()).getRecyclerScrollListener());

        api.susiesGet(MySharedPreferences.readToPreferences(getActivity(), getString(R.string.token_string), getString(R.string.empty_string)), start, end, type,
                new Callback<List<Susie>>() {
                    @Override
                    public void success(List<Susie> susies, Response response) {
                        adapterData.clear();
                        for (int i = 0; i < susies.size(); ++i) {
                            adapterData.add(susies.get(i));
                        }
                        mSusiesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.all:
                TYPE = "all";
                return true;
            case R.id.free:
                TYPE = "free";
                return true;
            case R.id.registered:
                TYPE = "registered";
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
