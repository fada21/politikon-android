package com.fada21.android.politikon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fada21.android.politikon.models.Bet;
import com.fada21.android.politikon.models.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<BetVH> {

    private final List<Event> betList;

    public EventAdapter(@NonNull final List<Event> bets) {
        betList = bets;
    }

    @Override public BetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bet_item, parent, false);
        return new BetVH(v);
    }

    @Override public void onBindViewHolder(BetVH holder, int position) {
        holder.bind(betList.get(position));
    }

    @Override public int getItemCount() {
        return betList.size();
    }
}
