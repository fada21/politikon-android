package com.fada21.android.politikon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

}
