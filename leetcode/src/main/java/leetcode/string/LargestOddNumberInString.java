package leetcode.string;

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

}
