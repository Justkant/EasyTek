package com.example.kant.epiandroid.Tabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Project;
import com.example.kant.epiandroid.EpitechAPI.Susie;
import com.example.kant.epiandroid.R;

import java.util.List;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class SusiesAdapter extends RecyclerView.Adapter<SusiesAdapter.MyViewHolder> {

    private List<Susie> susies;
    private LayoutInflater inflater;
    private ClickListener clickListener;

    public SusiesAdapter(Context context, List<Susie> susies) {
        inflater = LayoutInflater.from(context);
        this.susies = susies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.susie_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(susies.get(i).title);
    }

    @Override
    public int getItemCount() {
        return susies.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            title = (TextView) itemView.findViewById(R.id.susie_title);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
