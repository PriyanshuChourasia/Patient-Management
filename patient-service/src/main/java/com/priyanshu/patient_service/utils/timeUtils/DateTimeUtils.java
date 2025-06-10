package com.priyanshu.patient_service.utils.timeUtils;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateTimeUtils{
    public static long toEpochSecond(LocalDateTime localDateTime){
        if(localDateTime == null){
            throw new IllegalArgumentException("DateTime cannot be null");
        }
        return localDateTime.toEpochSecond(ZoneOffset.ofHoursMinutes(5,30));
    }
    
    
    public static LocalDate toLocalDate(Long dateofbirth){
        if(dateofbirth == null){
            throw new IllegalArgumentException("Date of Birth cannot be null");
        }
        Timestamp timestamp = new Timestamp(dateofbirth * 1000);
        LocalDate localDate = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
}