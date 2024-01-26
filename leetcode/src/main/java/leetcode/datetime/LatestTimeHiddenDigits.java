package leetcode.datetime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 *
 * Thay thế các dấu '?' để được giờ lớn nhất
 *
 * Note: Giờ hợp lệ là giờ nằm giữa '00:00' và '23:59'
 */
public class LatestTimeHiddenDigits {

	// hour first digit 	: 0-2
    // hour second digit 	: 0-9
    // minute first digit 	: 0-5
    // minute second digit 	: 0-9
	public static String maximumTime(String time) {
		char[] chars = time.toCharArray();
		if (chars[0] == '?') {
			if (chars[1] == '?' || chars[1] < '4') {
				chars[0] = '2';
			} else {
				chars[0] = '1';
			}
		}
		if (chars[1] == '?') {
			if (chars[0] == '2') {
				chars[1] = '3';
			} else {
				chars[1] = '9';
			}
		}
		if (chars[3] == '?') {
			chars[3] = '5';
		}
		if (chars[4] == '?') {
			chars[4] = '9';
		}
		return new String(chars);
	}

	@Test
	public void test() {
		assertEquals("23:50", maximumTime("2?:?0"));
		assertEquals("14:03", maximumTime("?4:03"));
		assertEquals("20:15", maximumTime("?0:15"));
	}

}
