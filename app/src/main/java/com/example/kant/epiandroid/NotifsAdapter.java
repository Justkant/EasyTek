package com.example.kant.epiandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kant.epiandroid.EpitechAPI.Message;

import java.util.List;

/**
 * Created by Quentin on 30/01/2015.
 * EpiAndroid Project.
 */
public class NotifsAdapter extends RecyclerView.Adapter<NotifsAdapter.MyViewHolder> {

    private List<Message> messages;
    private LayoutInflater inflater;
    private ClickListener clickListener;

    public NotifsAdapter(Context context, List<Message> messages) {
        inflater = LayoutInflater.from(context);
        this.messages = messages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.message_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(android.text.Html.fromHtml(messages.get(i).title).toString());
    }

    @Override
    public int getItemCount() {
        return messages.size();
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
            title = (TextView) itemView.findViewById(R.id.message_title);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClicked(getPosition());
            }
        }
    }
}
