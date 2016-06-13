package com.fada21.android.politikon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BetAdapter extends RecyclerView.Adapter<BetVH> {

    private final String[] data;

    public BetAdapter(@NonNull String[] betTitles) {
        data = betTitles;
    }

    @Override public BetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bet_item, parent, false);
        BetVH vh = new BetVH(v);
        return vh;
    }

    @Override public void onBindViewHolder(BetVH holder, int position) {
        holder.betItemTitleText.setText(data[position]);
    }

    @Override public int getItemCount() {
        return data.length;
    }
}
