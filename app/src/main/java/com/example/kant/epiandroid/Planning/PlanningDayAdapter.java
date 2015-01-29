package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Léopold Szabatura on 29/01/2015.
 */
public class PlanningDayAdapter extends RecyclerView.Adapter<PlanningDayAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ClickListener clickListener;
    private List<PlanningDayData> data;

    private Context context;

    public PlanningDayAdapter(Context context, List<PlanningDayData> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.plan_day_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        PlanningDayData bindData = data.get(i);

        viewHolder.dateNb.setText(bindData.dateNb);
        viewHolder.dateDay.setText(bindData.dateDay);

        // bind data to recycler
        viewHolder.data.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        viewHolder.data.setLayoutManager(layoutManager);

        ArrayList<PlanningItemData> data = new ArrayList<PlanningItemData>();
        for (int j = 0; j < 10; j++)
        {
            PlanningItemData newData = new PlanningItemData();
            newData.title = "title" + j;
            newData.time = "8:00 - 9:00";
            newData.description = "Sunday.. Everyday!";
            data.add(newData);
        }

        PlanningItemAdapter adapter = new PlanningItemAdapter(context, data);
        viewHolder.data.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView dateNb, dateDay;
        RecyclerView data;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            dateNb = (TextView) itemView.findViewById(R.id.tvDayDateNb);
            dateDay = (TextView) itemView.findViewById(R.id.tvDayDateDay);
            data = (RecyclerView) itemView.findViewById(R.id.cal_item_recycler_view);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
