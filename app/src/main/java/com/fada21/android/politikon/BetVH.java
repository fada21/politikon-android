package com.fada21.android.politikon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BetVH extends RecyclerView.ViewHolder {

    public TextView betItemTitleText;

    public BetVH(View itemView) {
        super(itemView);
        betItemTitleText = (TextView) itemView.findViewById(R.id.bet_item_title);
    }

}