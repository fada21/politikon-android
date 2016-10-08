package com.fada21.android.politikon.models;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class Dates {

    public static DateTimeFormatter ISO8601Formatter = ISODateTimeFormat.dateTime();

    public DateTime publish_date;
    public DateTime modify_date;
    public DateTime resolution_date;

    public static class DateAdapter {
        @ToJson String to(DateTime dateTime) {
            return ISO8601Formatter.print(dateTime);
        }

        @FromJson DateTime from(String dateTimeString) {
            return ISO8601Formatter.parseDateTime(dateTimeString);
        }
    }
}

/*
"id":1,
        "title":"Tom Hiddleston wciela się w rolę Jamesa Bonda",
        "content":"Do końca lipca 2016 r. przedstawiciel wytwórni EON Productions potwierdza udział aktora Toma Hiddlestona jako tytułowego bohatera nowego filmu o Jamesie Bondzie.",
        "image":"file://android_asset/bond.jpg",
        "dates":{
          "publish_date":"2016-01-31T23:59:59.999+01:00",
          "modify_date":"2016-01-31T23:59:59.999+01:00",
          "resolution_date":"2016-07-31T23:59:59.999+01:00"
        },
        "tags":[
          "newjamesbond"
        ],
        "yes_price":14,
        "no_price":86
 */
