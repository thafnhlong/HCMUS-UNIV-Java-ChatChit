package client.utils;

import java.time.ZoneId;
import java.util.Date;

public class DateTime {
    public static String getDMHMS(){
        var date = new Date();
        var localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        int month = localDateTime.getMonthValue();
        int day   = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int min = localDateTime.getMinute();
        int sen = localDateTime.getSecond();

        return ""+day+"/"+month+" "+hour+":"+min+":"+sen;
    }
}
