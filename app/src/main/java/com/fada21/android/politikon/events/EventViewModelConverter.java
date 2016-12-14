package com.fada21.android.politikon.events;

import com.fada21.android.politikon.repos.models.Event;

public class EventViewModelConverter {

    public EventViewModel convert(Event event) {
        return EventViewModel.create(event);
    }
}
