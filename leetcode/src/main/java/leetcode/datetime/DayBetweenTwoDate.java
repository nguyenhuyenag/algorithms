package leetcode.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class DayBetweenTwoDate {

	public long daysBetweenDates(String date1, String date2) {
		LocalDate d1 = LocalDate.parse(date1);
		LocalDate d2 = LocalDate.parse(date2);
		// return ChronoUnit.DAYS.between(d1, d2);
		return Duration.between(d1, d2).toDays();
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
