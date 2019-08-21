package financial_management.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 日期转化器
 * @Author 233loser
 * @Date 2019/6/11 17:34
 * @Version 1.0
 **/
public class DateConverterUtil {
    public static String dateToString(Date input) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(input);
    }

    public static Date stringToDate(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(input);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static LocalDateTime stringToLocalDateTime(String input) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(input, df);
    }

    public static String localDateTimeToString(LocalDateTime input) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return df.format(input);
    }

    public static String timestampToString(Timestamp input) {
        return localDateTimeToString(input.toLocalDateTime());
    }

    public static Timestamp stringToTimestamp(String input) {
        LocalDateTime now = stringToLocalDateTime(input);
        return Timestamp.valueOf(now);
    }

    public static String TimestampToTimeString(Timestamp input) {
        String in = timestampToString(input);
        return in.split(" ")[1];
    }

    public static Timestamp datesToTimestamp(Date year, LocalTime time) {
        Instant instant = year.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate lyear = instant.atZone(zoneId).toLocalDate();
        LocalDateTime localDateTime = LocalDateTime.of(lyear, time);

        return Timestamp.valueOf(localDateTime);

    }

    public static String timestampToTimeString(Timestamp input) {
        LocalDateTime ldt = input.toLocalDateTime();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        return df.format(ldt);
    }

    public static String timestampToYear(Timestamp input) {
        LocalDateTime ldt = input.toLocalDateTime();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return df.format(ldt);
    }

    public static Date moveForwardByDay(Date current,Integer step){
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.add(Calendar.DAY_OF_YEAR,step);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(cal.getTime());
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }
}
