package leetcode.string;

import leetcode.Main;

/**
 * Tìm số lẽ lớn nhất là chuỗi con của 1 chuỗi
 * 
 * https://leetcode.com/problems/largest-odd-number-in-string/description/
 */
public class LargestOddNumberInString {

	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			int currentChar = num.charAt(i);
			if (currentChar % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.largestOddNumber("35427")); // 35427
		System.out.println(m.largestOddNumber("52")); // 5
		System.out.println(m.largestOddNumber("4206")); // ""
	}

}
