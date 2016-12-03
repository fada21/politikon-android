package com.fada21.android.politikon.events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fada21.android.politikon.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventVH extends RecyclerView.ViewHolder {

    @BindView(R.id.bet_item_title)  TextView itemTitle;
    @BindView(R.id.bet_hero_image)  ImageView imageView;
    @BindView(R.id.bet_yes_price_btn)  TextView yesPrice;
    @BindView(R.id.bet_no_price_btn)  TextView noPrice;

    public EventVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(EventViewModel event) {
        final Context context = itemView.getContext();
        itemTitle.setText(event.title);
        Picasso.with(imageView.getContext()).load(event.imageUrl).into(imageView);
        final String yesPrice = context.getString(R.string.yes_price, event.yesPrice);
        this.yesPrice.setText(String.valueOf(yesPrice));
        final String noPrice = context.getString(R.string.no_price, event.noPrice);
        this.noPrice.setText(String.valueOf(noPrice));
    }

}
