package com.fada21.android.politikon.repos.models;

import org.joda.time.DateTime;

public class Event {
    public int id;
    public String title;
    public String short_title;
    public String twitter_tag;
    public String title_fb_yes;
    public String title_fb_no;
    public String description;
    public String small_image;
    public String big_image;
    public boolean is_feaured;
    public int outcome;
    public String outcome_reason;
    public DateTime created_date;
    public int created_by;
    public DateTime estimated_end_date;
    public DateTime end_date;
    public int current_buy_for_price;
    public int current_buy_against_price;
    public int current_sell_against_price;
    public DateTime last_transaction_date;
    public int Q_for;
    public int Q_against;
    public int turnover;
    public int absolute_price_change;
    public int price_change;
    public float B;

}

//        {
//            "id": 236,
//                "title": "Tylko polskie piosenki w TOP10 \"Trójki\"",
//                "short_title": "Tylko polskie piosenki w TOP10 \"Trójki\"",
//                "twitter_tag": "lp3",
//                "title_fb_yes": "Tylko polskie piosenki w TOP10 \"Trójki\"",
//                "title_fb_no": "Tylko polskie piosenki w TOP10 \"Trójki\"",
//                "description": "W pierwszej dziesiątce ostatniego sierpniowego notowania Listy Przebojów (nr 1804) radiowej \"Trójki\" będą wyłącznie utwory polskich wykonawców.\r\n\r\nTu aktualne notowanie: http://lp3.polskieradio.pl/",
//                "small_image": "https://politik.s3.amazonaws.com/events_small/przes%C5%82ano_27.5.2016_o_14_30_56.png",
//                "big_image": "https://politik.s3.amazonaws.com/events_big/przes%C5%82ano_27.5.2016_o_14_30_56.png",
//                "is_featured": true,
//                "outcome": 4,
//                "outcome_reason": "Piosenka zespołu Metallica na 4. i Joe Bonamassy na 10. miejscu w 1804. notowaniu rozstrzyga zakład na \"NIE\"",
//                "created_date": "2016-08-16T18:43:11.295055Z",
//                "created_by": 39,
//                "estimated_end_date": "2016-08-26T18:40:57Z",
//                "end_date": "2016-08-28T12:21:51.255641Z",
//                "current_buy_for_price": 20,
//                "current_buy_against_price": 80,
//                "current_sell_against_price": 77,
//                "last_transaction_date": null,
//                "Q_for": 6,
//                "Q_against": 13,
//                "turnover": 19,
//                "absolute_price_change": 7,
//                "price_change": -7,
//                "B": 5.0
//        },
