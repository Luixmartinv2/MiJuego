package com.mijuego;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by luixmartinv2 on 15/6/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>{

    private ArrayList<FBUsers> users;
    private Context mContext;

    public UsersAdapter (ArrayList<FBUsers> users, Context mContext) {
        this.users = users;
        this.mContext = mContext;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
