package codewars.incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/52742f58faf5485cae000b9a/
 */
public class HumanReadbleDurationFormat {

//    public static String formatTime(int days, int hours, int minutes, int seconds) {
//        if (seconds == 0) {
//            return "now";
//        }
//
//        int year = seconds / (365 * 24 * 60 * 60);
//        int day = (seconds % (365 * 24 * 60 * 60)) / (24 * 60 * 60);
//        int hour = (seconds % (24 * 60 * 60)) / (60 * 60);
//        int minute = (seconds % (60 * 60)) / 60;
//        int second = seconds % 60;
//
//        StringBuilder result = new StringBuilder();
//
//        if (year > 0) {
//            result.append(year).append(year > 1 ? " years" : " year");
//        }
//        if (day > 0) {
//            if (result.length() > 0) {
//                result.append(", ");
//            }
//            result.append(day).append(day > 1 ? " days" : " day");
//        }
//        if (hour > 0) {
//            if (result.length() > 0) {
//                result.append(", ");
//            }
//            result.append(hour).append(hour > 1 ? " hours" : " hour");
//        }
//        if (minute > 0) {
//            if (result.length() > 0) {
//                result.append(", ");
//            }
//            result.append(minute).append(minute > 1 ? " minutes" : " minute");
//        }
//        if (second > 0) {
//            if (result.length() > 0) {
//                result.append(" and ");
//            }
//            result.append(second).append(second > 1 ? " seconds" : " second");
//        }
//
//        return result.toString();
//    }

    public static String formatDuration(int seconds) {
//        // Tính ngày
//        int days = time / (24 * 3600);
//        time %= (24 * 3600); // Phần dư còn lại
//
//        // Tính giờ
//        int hours = time / 3600;
//        time %= 3600;
//
//        // Tính phút
//        int minutes = time / 60;
//
//        // Tính giây
//        int seconds = time % 60;
//
//        return formatTime(days, hours, minutes, seconds);

        if (seconds == 0) {
            return "now";
        }

        // int year = seconds / (365 * 24 * 60 * 60);
        int day = (seconds % (365 * 24 * 60 * 60)) / (24 * 60 * 60);
        int hour = (seconds % (24 * 60 * 60)) / (60 * 60);
        int minute = (seconds % (60 * 60)) / 60;
        int second = seconds % 60;

        StringBuilder result = new StringBuilder();

//        if (year > 0) {
//            result.append(year).append(year > 1 ? " years" : " year");
//        }
        if (day > 0) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(day).append(day > 1 ? " days" : " day");
        }
        if (hour > 0) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(hour).append(hour > 1 ? " hours" : " hour");
        }
        if (minute > 0) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(minute).append(minute > 1 ? " minutes" : " minute");
        }
        if (second > 0) {
            if (result.length() > 0) {
                result.append(" and ");
            }
            result.append(second).append(second > 1 ? " seconds" : " second");
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("1 second", formatDuration(1));
        assertEquals("1 minute and 2 seconds", formatDuration(62));
        assertEquals("2 minutes", formatDuration(120));
        assertEquals("1 hour", formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662));
    }

}
