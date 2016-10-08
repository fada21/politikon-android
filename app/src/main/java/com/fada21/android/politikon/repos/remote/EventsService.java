package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.models.Bet;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface EventsService {

    @GET("/events")
    Observable<List<Bet>> getEvents();

    @GET("/events/{event}")
    Observable<Bet> getEvent(@Path("event") String event);

}
