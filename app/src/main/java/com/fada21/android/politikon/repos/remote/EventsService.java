package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.repos.models.EventData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface EventsService {

    @GET("events/")
    Observable<EventData> getEvents(@Query("page_size") int pageSize);

}
