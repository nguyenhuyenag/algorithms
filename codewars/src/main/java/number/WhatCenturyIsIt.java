package number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/52fb87703c1351ebd200081f/
 * 
 * Xem thêm: CenturyFromYear.java
 */
public class WhatCenturyIsIt {
	
	public static int getCentury(int year) {
		return (year % 100 == 0) ? year / 100 : year / 100 + 1;
	}

	public static String whatCentury(int year) {
		String suffix;
		// int century = (year - 1) / 100 + 1;
		int century = getCentury(year);
		int yearWithinCentury = century % 100; // Biểu thị năm trong khoảng 0 đến 99 của thế kỷ
		if (11 <= yearWithinCentury && yearWithinCentury <= 13) {
			suffix = "th";
		} else {
			suffix = switch (century % 10) {
				case 1 -> "st";
				case 2 -> "nd";
				case 3 -> "rd";
				default -> "th";
			};
		}
		return century + suffix;
	}
	
	@ParameterizedTest
    @CsvSource({
        "9720, 98th",
        "6077, 61st",
        "1435, 15th",
        "3415, 35th",
        "9548, 96th",
        "2913, 30th",
        "9156, 92nd",
        "3876, 39th",
        "8996, 90th",
        "1855, 19th",
        "4363, 44th",
        "1307, 14th",
        "7698, 77th",
        "6024, 61st",
        "8962, 90th",
        "4551, 46th",
        "6488, 65th",
        "8361, 84th",
        "9597, 96th",
        "4963, 50th",
        "8044, 81st",
        "3842, 39th",
        "4956, 50th",
        "9444, 95th",
        "9186, 92nd",
        "6427, 65th",
        "8573, 86th",
        "4970, 50th",
        "4105, 42nd",
        "8163, 82nd",
        "8566, 86th",
        "3531, 36th",
        "1135, 12th"
    })
    public void testWhatCentury(int year, String expected) {
        assertEquals(expected, whatCentury(year));
    }

//	@ParameterizedTest
//	@CsvFileSource(resources = "/your_test_data.csv", numLinesToSkip = 1)
//	public void testYourProgram(int input, int expected, int actual) {
//		assertEquals(expected, actual);
//	}

}
