package com.fada21.android.politikon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BetAdapter extends RecyclerView.Adapter<BetVH> {

    private final List<Bet> betList;

    public BetAdapter(@NonNull final List<Bet> bets) {
        betList = bets;
    }

    @Override public BetVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bet_item, parent, false);
        BetVH vh = new BetVH(v);
        return vh;
    }

    @Override public void onBindViewHolder(BetVH holder, int position) {
        final Bet bet = betList.get(position);
        final Context context = holder.itemView.getContext();
        holder.betItemTitleText.setText(bet.title);
        Picasso.with(holder.betItemImage.getContext()).load(bet.image).into(holder.betItemImage);
        final String yesPrice = context.getString(R.string.yes_price, bet.yes_price);
        holder.betYesPrice.setText( String.valueOf(yesPrice));
        final String noPrice = context.getString(R.string.no_price, bet.no_price);
        holder.betNoPrice.setText(String.valueOf(noPrice));
    }

    @Override public int getItemCount() {
        return betList.size();
    }
}
