package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.repos.models.Event;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface EventsService {

    @GET("/events")
    Observable<List<Event>> getEvents();

}
