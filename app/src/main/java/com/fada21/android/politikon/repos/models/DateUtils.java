package com.fada21.android.politikon.repos.models;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateUtils {

    static DateTimeFormatter ISO8601Formatter = ISODateTimeFormat.dateTime();

    public static class DateAdapter {
        @ToJson String to(DateTime dateTime) {
            return dateTime != null ? ISO8601Formatter.print(dateTime) : null;
        }

        @FromJson DateTime from(String dateTimeString) {
            return dateTimeString != null ? ISO8601Formatter.parseDateTime(dateTimeString) : null;
        }
    }
}
