package com.fada21.android.politikon.events;

import com.fada21.android.politikon.repos.models.Event;

public class EventViewModelConverter {

    public EventViewModel convert(Event event) {
        EventViewModel viewModel = new EventViewModel();
        viewModel.title = event.title;
        viewModel.imageUrl = event.small_image;
        viewModel.yesPrice = event.current_buy_for_price;
        viewModel.noPrice = event.current_buy_against_price;
//        viewModel.isResolved = event.end_date != null;
//        viewModel.estimatedEndDate = event.estimated_end_date;
//        viewModel.endDate = event.end_date;
        return viewModel;
    }
}
