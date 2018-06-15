package com.mijuego;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luixmartinv2 on 15/6/18.
 */

public class UsersViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView record;
    public UsersAdapterListener listener;

    public void setListener(UsersAdapterListener listener) {
        this.listener = listener;
    }


    public UsersViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textViewName);
        record = itemView.findViewById(R.id.textViewRecord);
        UsersViewHolderEvents events = new UsersViewHolderEvents(this);
        itemView.setOnClickListener(events);
    }
}


class UsersViewHolderEvents implements View.OnClickListener {

    UsersViewHolder usersViewHolder;

    public UsersViewHolderEvents(UsersViewHolder usersViewHolder) {
        this.usersViewHolder = usersViewHolder;
    }

    @Override
    public void onClick(View v) {
        Log.v("Celda pulsada","celda presionada");
    }
}
