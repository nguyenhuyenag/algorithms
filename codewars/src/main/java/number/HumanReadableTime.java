package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Chủ đề: Time
 *
 * Chuyển số thành giờ
 */
public class HumanReadableTime {

    public static String format(int n) {
        if (n < 10) {
            return "0" + n;
        }
        return String.valueOf(n);
    }

    public static String makeReadable(int seconds) {
        int h = seconds / 3600;
        seconds = seconds - h * 3600;

        int m = seconds / 60;
        seconds = seconds - m * 60;

        return format(h) + ":" + format(m) + ":" + format(seconds);
    }

    public static String _makeReadable(int seconds) {
        int h = seconds / 60 / 60;
        int min = seconds / 60 % 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d:%02d", h, min, sec);
    }

    @Test
    public void Tests() {
        assertEquals("00:00:00", makeReadable(0));
        assertEquals("00:00:05", makeReadable(5));
        assertEquals("00:01:00", makeReadable(60));
        assertEquals("23:59:59", makeReadable(86399));
        assertEquals("99:59:59", makeReadable(359999));
    }

}
