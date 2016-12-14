package com.fada21.android.politikon.events;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fada21.android.politikon.EventActivity;
import com.fada21.android.politikon.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventVH> {

    private final List<EventViewModel> events;

    public EventAdapter(@NonNull final List<EventViewModel> events) {
        this.events = events;
    }

    @Override public EventVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bet_item, parent, false);
        return new EventVH(v, getOnClicksListener(parent.getContext()));
    }

    OnClicksListener getOnClicksListener(Context context) {
        return new OnClicksListener() {
            @Override public void onItemClicked(EventViewModel eventVM) {
                if (eventVM != null) {
                    context.startActivity(new Intent(context, EventActivity.class).putExtra(EventActivity.EXTRA_EVENT, eventVM));
                }
            }

            @Override public void onBuyForClicked(EventViewModel eventVM) {
                if (eventVM != null) {
                    Toast.makeText(context,
                                   String.format("Bought for %d %s", eventVM.yesPrice(), eventVM.title()),
                                   Toast.LENGTH_SHORT).show();
                }
            }

            @Override public void onBuyAgainstClicked(EventViewModel eventVM) {
                if (eventVM != null) {
                    Toast.makeText(context,
                                   String.format("Sold for %d %s", eventVM.noPrice(), eventVM.title()),
                                   Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override public void onBindViewHolder(EventVH holder, int position) {
        holder.bind(events.get(position));
    }

    @Override public int getItemCount() {
        return events.size();
    }

    public interface OnClicksListener {
        void onItemClicked(EventViewModel eventViewModel);

        void onBuyForClicked(EventViewModel eventViewModel);

        void onBuyAgainstClicked(EventViewModel eventViewModel);
    }
}
