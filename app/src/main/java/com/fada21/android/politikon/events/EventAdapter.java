package com.fada21.android.politikon.events;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        return new EventVH(v, position ->
                Toast.makeText(parent.getContext(),
                               String.format("%s position clicked", events.get(position).title),
                               Toast.LENGTH_SHORT).show());
    }

    @Override public void onBindViewHolder(EventVH holder, int position) {
        holder.bind(events.get(position));
    }

    @Override public int getItemCount() {
        return events.size();
    }

    public interface OnClicksListener {
        void onItemClicked(int position);
    }
}
