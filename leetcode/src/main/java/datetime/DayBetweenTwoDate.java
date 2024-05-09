package datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 *
 * Tìm khoảng cách giữa 2 ngày
 */
public class DayBetweenTwoDate {

    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        // return (int) Duration.between(d1, d2).toDays();
        int diff = (int) ChronoUnit.DAYS.between(d1, d2);
        return Math.abs(diff);
    }

    @Test
    public void test() {
        assertEquals(1, daysBetweenDates("2019-06-29", "2019-06-30"));
        assertEquals(15, daysBetweenDates("2020-01-15", "2019-12-31"));
    }

//    public int daysBetweenDates(Date d1, Date d2) {
//        long diff = d2.getTime() - d1.getTime();
//        int d = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//        return Math.abs(d);
//    }

}
