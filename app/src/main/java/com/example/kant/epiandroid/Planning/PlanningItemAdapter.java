package com.example.kant.epiandroid.Planning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.R;

import java.util.List;

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
        viewHolder.time.setText(bindData.time);
        viewHolder.description.setText(bindData.description);
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

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.tvPlanTitle);
            time = (TextView) itemView.findViewById(R.id.tvPlanTime);
            description = (TextView) itemView.findViewById(R.id.tvPlanDescription);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}