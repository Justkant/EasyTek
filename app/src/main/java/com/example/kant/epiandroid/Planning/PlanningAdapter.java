package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Planning;
import com.example.kant.epiandroid.R;

import java.util.List;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ClickListener clickListener;
    private List<Planning> plannings;

    public PlanningAdapter(Context context, List<Planning> plannings) {
        inflater = LayoutInflater.from(context);
        this.plannings = plannings;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.planning_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.planningTitle.setText(plannings.get(i).acti_title + " " + plannings.get(i).start);

    }

    @Override
    public int getItemCount() {
        return plannings.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView planningTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            planningTitle = (TextView) itemView.findViewById(R.id.planning_title);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
