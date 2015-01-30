package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class PlanningItemAdapter extends RecyclerView.Adapter<PlanningItemAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ClickListener clickListener;
    private List<PlanningItemData> data;

    public PlanningItemAdapter(Context context, List<PlanningItemData> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.plan_cards_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        PlanningItemData bindData = data.get(i);

        viewHolder.title.setText(bindData.title);
        viewHolder.description.setText(bindData.description);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        viewHolder.time.setText(sdf.format(bindData.dateStart.getTime()) + " - " + sdf.format(bindData.dateEnd.getTime()));

        if (bindData.isFirstOfTheDay) {
            viewHolder.dateNb.setVisibility(View.VISIBLE);
            viewHolder.dateDay.setVisibility(View.VISIBLE);
            viewHolder.dateNb.setText(new SimpleDateFormat("dd", Locale.US).format(bindData.dateStart.getTime()));
            viewHolder.dateDay.setText(new SimpleDateFormat("EEE", Locale.US).format(bindData.dateStart.getTime()));
        } else {
            viewHolder.dateNb.setVisibility(View.GONE);
            viewHolder.dateDay.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        // add here your booleans or switch() to set viewType at your needed
        // I.E if (position == 0) viewType = 1; etc. etc.
        return viewType;
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

        TextView title;
        TextView time;
        TextView description;

        TextView dateNb;
        TextView dateDay;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.tvPlanTitle);
            time = (TextView) itemView.findViewById(R.id.tvPlanTime);
            description = (TextView) itemView.findViewById(R.id.tvPlanDescription);
            dateNb = (TextView) itemView.findViewById(R.id.tvPlanDateNb);
            dateDay = (TextView) itemView.findViewById(R.id.tvPlanDateDay);
        }


        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}