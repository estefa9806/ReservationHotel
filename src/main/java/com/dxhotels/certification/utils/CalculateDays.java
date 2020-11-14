package com.dxhotels.certification.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateDays {
    public static int numberOfDays(String date, String endDate) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date checkInDate = myFormat.parse(date);
        Date checkOutDate = myFormat.parse(endDate);
        int value = (int) ((checkOutDate.getTime() - checkInDate.getTime()) / 86400000);
        return value;
    }
}

