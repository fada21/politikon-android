package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.PolitikonApp;
import com.fada21.android.politikon.repos.models.DateUtils;
import com.fada21.android.politikon.repos.models.Event;
import com.fada21.android.politikon.repos.models.EventData;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import okio.BufferedSource;
import okio.Okio;
import rx.Observable;

public class RemotePolitikonRepo implements RemotePolitikonApi {

    @Override public EventsService getEventsService() {
        return new EventsService() {
            @Override public Observable<List<Event>> getEvents() {
                return Observable.just(getStub());
            }
        };
    }

    List<Event> getStub() {
        final Moshi moshi = new Moshi.Builder().add(new DateUtils.DateAdapter()).build();
        JsonAdapter<EventData> eventDataJsonAdapter = moshi.adapter(EventData.class);

        InputStream inputStream = null;
        List<Event> events;
        try {
            inputStream = PolitikonApp.get().getAssets().open("get_events.json");
            final BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream));
            events = eventDataJsonAdapter.fromJson(bufferedSource).results;
        } catch (IOException ioe) {
            events = Collections.emptyList();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioe) {
                    // TODO log
                }
            }
        }
        return events;
    }
}