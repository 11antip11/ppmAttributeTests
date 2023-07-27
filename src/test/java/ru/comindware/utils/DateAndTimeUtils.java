package ru.comindware.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateAndTimeUtils {
    private String str;
    public String DateAndTimeFormatter(Calendar date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(df.format(date.getTime()));
        str = df.format(date.getTime());
        return str;
    }
    public String LocalDateAndTimeFormatter(LocalDate localDate){
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(df.format(calendar.getTime()));
        str = df.format(date.getTime());
        return str;
    }
}
