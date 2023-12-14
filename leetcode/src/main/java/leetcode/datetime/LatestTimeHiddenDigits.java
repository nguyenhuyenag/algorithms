package leetcode.datetime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * You are given a string time in the form of hh:mm, where some of the digits in
 * the string are hidden (represented by ?)
 * 
 * The valid times are those inclusively between 00:00 and 23:59
 * 
 * Return the latest valid time you can get from time by replacing the hidden
 * digits
 * 
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class LatestTimeHiddenDigits {

	// hour first digit 	: 0-2
    // hour second digit 	: 0-9
    // minute first digit 	: 0-5
    // minute second digit 	: 0-9
	public static String maximumTime(String time) {
		char[] A = time.toCharArray();
		if (A[0] == '?') {
			if (A[1] == '?' || A[1] < '4') {
				A[0] = '2';
			} else {
				A[0] = '1';
			}
		}
		if (A[1] == '?') {
			if (A[0] == '2') {
				A[1] = '3';
			} else {
				A[1] = '9';
			}
		}
		if (A[3] == '?') {
			A[3] = '5';
		}
		if (A[4] == '?') {
			A[4] = '9';
		}
		return new String(A);
	}

	@Test
	public void test() {
		assertEquals("23:50", maximumTime("2?:?0"));
		assertEquals("14:03", maximumTime("?4:03"));
		assertEquals("20:15", maximumTime("?0:15"));
	}

}
