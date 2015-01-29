package com.example.kant.epiandroid.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kant.epiandroid.R;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class ModulesFragment extends Fragment implements ModulesAdapter.ClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.board_recycler);

        // TODO: getData
        ModulesAdapter mModulesAdapter = new ModulesAdapter(getActivity(), 0);
        mModulesAdapter.setClickListener(this);

        mRecyclerView.setAdapter(mModulesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void itemClicked(int position) {

    }
}
