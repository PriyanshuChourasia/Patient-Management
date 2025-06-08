package com.priyanshu.patient_service.utils.timeUtils;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeUtils{
    public static long toEpochSecond(LocalDateTime localDateTime){
        if(localDateTime == null){
            throw new IllegalArgumentException("DateTime cannot be null");
        }
        return localDateTime.toEpochSecond(ZoneOffset.ofHoursMinutes(5,30));
    }
}