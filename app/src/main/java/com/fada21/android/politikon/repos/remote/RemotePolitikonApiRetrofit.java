package com.fada21.android.politikon.repos.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RemotePolitikonApiRetrofit implements RemotePolitikonApi {

    private final Retrofit retrofit;

    public RemotePolitikonApiRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://politikon.org.pl/api")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Override public EventsService getEventsService() {
        return retrofit.create(EventsService.class);
    }
}
