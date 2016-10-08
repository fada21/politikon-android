package com.fada21.android.politikon;

import android.content.Context;

import com.fada21.android.politikon.models.Bet;
import com.fada21.android.politikon.models.BetData;
import com.fada21.android.politikon.models.Dates;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import okio.BufferedSource;
import okio.Okio;

public class DummyBetsProvider {

    public static List<Bet> getBets(final Context context) {
        final Moshi moshi = new Moshi.Builder().add(new Dates.DateAdapter()).build();
        JsonAdapter<BetData> betJsonAdapter = moshi.adapter(BetData.class);

        InputStream inputStream = null;
        List<Bet> bets;
        try {
            inputStream = context.getAssets().open("politikon_dummy.json");
            final BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream));
            bets = betJsonAdapter.fromJson(bufferedSource).data.events;
        } catch (IOException ioe) {
            bets = Collections.emptyList();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioe) {
                    // TODO log
                }
            }
        }
        return bets;
    }
}
