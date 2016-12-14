package com.fada21.android.politikon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fada21.android.politikon.events.EventAdapter;
import com.fada21.android.politikon.events.EventVH;
import com.fada21.android.politikon.events.EventViewModel;

public class EventActivity extends AppCompatActivity {

    public static final String EXTRA_EVENT = "EXTRA_EVENT";

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_event);
        final EventViewModel eventVM = getIntent().getParcelableExtra(EXTRA_EVENT);
        Toast.makeText(this, eventVM.title(), Toast.LENGTH_SHORT).show();
        final View view = findViewById(android.R.id.content);
        new EventVH(view, new EventAdapter.OnClicksListener() {
            @Override public void onItemClicked(EventViewModel eventViewModel) {

            }

            @Override public void onBuyForClicked(EventViewModel eventViewModel) {

            }

            @Override public void onBuyAgainstClicked(EventViewModel eventViewModel) {

            }
        }).bind(eventVM);
        ((TextView) view.findViewById(R.id.description)).setText(eventVM.descripton());
    }
}
