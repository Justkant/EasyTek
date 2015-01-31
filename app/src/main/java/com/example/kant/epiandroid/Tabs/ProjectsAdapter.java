package com.example.kant.epiandroid.Tabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Projects;
import com.example.kant.epiandroid.R;

import java.util.List;

/**
 * Created by Quentin on 28/01/2015.
 * EpiAndroid Project.
 */
public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder> {

    private List<Projects> projects;
    private LayoutInflater inflater;
    private ClickListener clickListener;

    public ProjectsAdapter(Context context, List<Projects> projects) {
        inflater = LayoutInflater.from(context);
        this.projects = projects;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.project_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(projects.get(i).acti_title);
    }

    @Override
    public int getItemCount() {
        return projects.size();
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
            title = (TextView) itemView.findViewById(R.id.project_title);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
