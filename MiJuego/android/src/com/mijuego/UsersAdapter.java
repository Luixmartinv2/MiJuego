package com.mijuego;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by luixmartinv2 on 15/6/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>{

    private ArrayList<FBUsers> users;
    private Context mContext;
    private UsersAdapterListener listener;

    public UsersAdapter (ArrayList<FBUsers> users, Context mContext) {
        this.users = users;
        this.mContext = mContext;
    }

    public void setListener(UsersAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_record, null);
        UsersViewHolder userViewHolder = new UsersViewHolder(v);
        return userViewHolder;
    }

    //Seteo info
    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.name.setText(users.get(position).name + "");
        holder.record.setText(users.get(position).record + "");
        holder.setListener(this.listener);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
