package com.example.kant.epiandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<CalendarData> data;

    public CalendarAdapter(Context context, List<CalendarData> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.cal_cards_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        CalendarData bindData = data.get(i);

        viewHolder.title.setText(bindData.title);
        viewHolder.time.setText(bindData.time);
        viewHolder.description.setText(bindData.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView time;
        TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            time = (TextView) itemView.findViewById(R.id.tvTime);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}