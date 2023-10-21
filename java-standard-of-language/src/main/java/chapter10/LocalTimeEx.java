package chapter10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeEx {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        LocalDate fixedDate = LocalDate.of(1999, 12, 31);
        LocalTime fixedTime = LocalTime.of(23, 59, 59);

        System.out.println("today="+today);
        System.out.println("now="+now);
        System.out.println("fixedDate="+fixedDate);
        System.out.println("fixedTime="+fixedTime);

        System.out.println(fixedDate.withYear(2000));
        System.out.println(fixedDate.plusDays(1));
        System.out.println(fixedDate.plus(1, ChronoUnit.DAYS));

        // 23:59:59 -> 23:00
        System.out.println(fixedTime.truncatedTo(ChronoUnit.HOURS));

        System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());  // 1-24
        System.out.println(ChronoField.HOUR_OF_DAY.range());        // 0-23
    }
}
