package com.fada21.android.politikon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fada21.android.politikon.models.Bet;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BetVH extends RecyclerView.ViewHolder {

    @BindView(R.id.bet_item_title) TextView betItemTitleText;
    @BindView(R.id.bet_hero_image) ImageView betItemImage;
    @BindView(R.id.bet_yes_price_btn) TextView betYesPrice;
    @BindView(R.id.bet_no_price_btn) TextView betNoPrice;

    public BetVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Bet bet) {
        final Context context = itemView.getContext();
        betItemTitleText.setText(bet.title);
        Picasso.with(betItemImage.getContext()).load(bet.image).into(betItemImage);
        final String yesPrice = context.getString(R.string.yes_price, bet.yes_price);
        betYesPrice.setText(String.valueOf(yesPrice));
        final String noPrice = context.getString(R.string.no_price, bet.no_price);
        betNoPrice.setText(String.valueOf(noPrice));
    }

}
