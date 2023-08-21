package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * VD: "ababab" -> ab{3}
 */
public class RepeatedSubstringPattern {

	// Time Limit Exceeded
	public boolean repeatedSubstringPattern0(String input) {
		for (int i = 0; i < input.length() / 2; i++) {
			String sub = input.substring(0, i + 1);
			// System.out.println("i=" + i + ", " + "sub: " + sub);
			String afterReplace = input.replaceAll(sub, "");
			// System.out.println("afterReplace: " + afterReplace + ", length: " +
			// afterReplace.length());
			if (afterReplace.length() == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean repeatedSubstringPattern_OK(String input) {
		int len = input.length();
		// Chỉ lặp đến len/2, vì nếu vượt quá thì chuỗi mới sẽ dài hơn chuỗi gốc
		for (int i = 1; i <= len / 2; i++) {
			if (len % i == 0) {
				String substring = input.substring(0, i);
				StringBuilder repeated = new StringBuilder();
				// Repeat the substring to check if it can construct the original string
				for (int j = 0; j < len / i; j++) {
					repeated.append(substring);
				}
				if (repeated.toString().equals(input)) {
					return true;
				}
			}
		}
		return false;
	}

//	public boolean repeatedSubstringPattern(String str) {
//		if (str.length() == 1) {
//			return false;
//		}
//		Map<Character, Integer> map = new HashMap<>();
//		for (char key : str.toCharArray()) {
//			map.compute(key, (character, count) -> count == null ? 1 : ++count);
//		}
//		Set<Integer> values = new HashSet<>(map.values());
//		return values.size() == 1;
//	}

	@Test
	public void test() {
		// assertEquals(false, repeatedSubstringPattern("aba"));
		// assertEquals(true, repeatedSubstringPattern("ababab"));
		assertEquals(false, repeatedSubstringPattern_OK("a"));
	}

}
