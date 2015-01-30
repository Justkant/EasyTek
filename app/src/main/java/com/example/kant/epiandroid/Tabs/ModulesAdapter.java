package com.example.kant.epiandroid.Tabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Modules;
import com.example.kant.epiandroid.R;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.MyViewHolder> {

    private Modules data;
    private LayoutInflater inflater;
    private ClickListener clickListener;

    public ModulesAdapter(Context context, Modules data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.module_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.moduleTitle.setText(data.modules.get(i).title + " Grade : " + data.modules.get(i).grade);
    }

    @Override
    public int getItemCount() {
        return data.modules.size();
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView moduleTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            moduleTitle = (TextView) itemView.findViewById(R.id.module_title);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
