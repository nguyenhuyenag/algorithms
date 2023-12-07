package leetcode;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
 */
public class Main {

	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			char c = num.charAt(i);
			if ((int) c % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.largestOddNumber("35427"));
		System.out.println(m.largestOddNumber("52"));
		System.out.println(m.largestOddNumber("4206"));
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
