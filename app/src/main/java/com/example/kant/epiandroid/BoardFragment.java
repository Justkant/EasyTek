package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Quentin on 23/01/2015.
 */
public class BoardFragment extends Fragment {
    private TextView textView;

    public static BoardFragment getInstance(int position) {
        BoardFragment boardFragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        boardFragment.setArguments(args);
        return boardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        textView = (TextView) view.findViewById(R.id.position);
        Bundle args = getArguments();
        if (args != null) {
            textView.setText("The page selected is " + args.getInt("position"));
        }
        return view;
    }
}
