package com.fada21.android.politikon.events;

import android.os.Parcelable;

import com.fada21.android.politikon.repos.models.Event;
import com.google.auto.value.AutoValue;

import org.joda.time.DateTime;

@AutoValue
public abstract class EventViewModel implements Parcelable {

    public static EventViewModel create(Event event) {
        return new AutoValue_EventViewModel(
                event.title,
                event.description,
                event.small_image,
                event.current_buy_for_price,
                event.current_buy_against_price,
                event.end_date == null,
                event.end_date
        );
    }

    public abstract String title();
    public abstract String descripton();
    public abstract String imageUrl();
    public abstract int yesPrice();
    public abstract int noPrice();
    public abstract boolean isResolved();
//  public   abstract DateTime estimatedEndDate();
    public abstract DateTime endDate();

}
