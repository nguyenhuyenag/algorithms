package leetcode.string;

/*-
 * def largestGoodInteger(self, num: str) -> str:
        templates = ["999", "888", "777", "666", "555", "444", "333", "222", "111", "000"]

        for t in templates:
            if t in num:
                return t
        return ""
 */
/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
 */
public class Largest3SameDigit {

	public boolean isSameDigit(String numberStr) {
		char firstDigit = numberStr.charAt(0);
		for (int i = 1; i < numberStr.length(); i++) {
			if (firstDigit != numberStr.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public String largestGoodInteger_OK(String num) {
		int max = -1;
		int len = num.length();
		for (int i = 0; i <= len - 3; i++) {
			String t = num.substring(i, i + 3);
			if (isSameDigit(t)) {
				max = Math.max(max, Integer.parseInt(t));
			}
		}
		if (max == 0) {
			return "000";
		}
		String smax = String.valueOf(max);
		return isSameDigit(smax) ? smax : "";
	}
	

	public String largestGoodInteger(String numberStr) {
		String max = "";
		char[] num = numberStr.toCharArray();
		for (int i = 2; i < num.length; i++) {
			if (num[i - 1] == num[i] && num[i] == num[i - 2]) {
				String str = num[i - 2] + num[i - 1] + num[i] + "";
				if (Integer.parseInt(str) > Integer.parseInt(max)) {
					max = str;
				}
			}
		}
		return max;
	}

	@org.junit.jupiter.api.Test
	public void test() {
		// System.out.println(isSameDigit("300"));

		// assertEquals("777", largestGoodInteger("6777133339"));
		// assertEquals("000", largestGoodInteger("2300019"));
		// assertEquals("", largestGoodInteger("101010"));
	}

}
