package codewars.incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/52742f58faf5485cae000b9a/
 */
public class HumanReadbleDurationFormat {

    public static String formatTime(int days, int hours, int minutes, int seconds) {
        StringBuilder result = new StringBuilder();
        if (days > 0) {
            result.append(days).append(days > 1 ? " days" : " day");
            if (hours > 0 || minutes > 0 || seconds > 0) {
                result.append(", ");
            }
        }
        if (hours > 0) {
            result.append(hours).append(hours > 1 ? " hours" : " hour");
            if (minutes > 0 || seconds > 0) {
                result.append(", ");
            }
        }
        if (minutes > 0) {
            result.append(minutes).append(minutes > 1 ? " minutes" : " minute");
            result.append(seconds > 0 ? " and " : "");
        }
        if (seconds > 0) {
            result.append(seconds).append(seconds > 1 ? " seconds" : " second");
        }
        return result.toString();
    }

    public static String formatDuration(int time) {
        // Tính ngày
        int days = time / (24 * 3600);
        time %= (24 * 3600); // Phần dư còn lại

        // Tính giờ
        int hours = time / 3600;
        time %= 3600;

        // Tính phút
        int minutes = time / 60;

        // Tính giây
        int seconds = time % 60;

        return formatTime(days, hours, minutes, seconds);
    }

    @Test
    public void test() {
//        assertEquals("1 second", formatDuration(1));
//        assertEquals("1 minute and 2 seconds", formatDuration(62));
//        assertEquals("2 minutes", formatDuration(120));
//        assertEquals("1 hour", formatDuration(3600));
//        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662));
        assertEquals("19 days, 5 hours, 44 seconds", formatDuration(1644240 + 16 * 60 + 4 * 3600 + 44 * 60));
    }


}
