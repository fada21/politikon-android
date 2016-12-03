package com.fada21.android.politikon.repos.remote;

import com.fada21.android.politikon.PolitikonApp;
import com.fada21.android.politikon.repos.models.DateUtils;
import com.squareup.moshi.Moshi;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RemotePolitikonRepo implements RemotePolitikonApi {

    private final Retrofit retrofit;

    public RemotePolitikonRepo() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(PolitikonApp.get().getCacheDir(), cacheSize);
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {

            @Override public boolean verify(String s, SSLSession sslSession) {
                return "www.politikon.org.pl".equals(s);
            }
        };
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .hostnameVerifier(hostnameVerifier)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.politikon.org.pl/api/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add(new DateUtils.DateAdapter()).build()))
                .build();
    }

    @Override public EventsService getEventsService() {
        return retrofit.create(EventsService.class);
    }
}
