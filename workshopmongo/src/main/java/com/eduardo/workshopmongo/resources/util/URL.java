package com.eduardo.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
    public static Date convertDate(String textDate, Date defaultDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(textDate);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
