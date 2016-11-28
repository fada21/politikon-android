package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.repos.models.DateUtils;
import com.squareup.moshi.Moshi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RemotePolitikonRepo implements RemotePolitikonApi {

    private final Retrofit retrofit;

    public RemotePolitikonRepo() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://politikon.org.pl/api")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add(new DateUtils.DateAdapter()).build()))
                .build();
    }

    @Override public EventsService getEventsService() {
        return retrofit.create(EventsService.class);
    }
}
