package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

// https://voz.vn/t/leetcode-moi-ngay.568742/page-183#post-25048593
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
public class Main {

	public int maxVowels(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : "aeoui".toCharArray()) {
			map.put(c, 0);
		}
		for (int i = 0; i < s.length() - 3; i++) {
			String sub = s.substring(i, i + 3);
			System.out.println(sub);
		}
		return 0;
	}

	@Test
	public void test() {
		// s = "abciiidef", k = 3
		assertEquals(3, maxVowels("abciiidef", 3));
	}

	public static void main(String[] args) {
		String s = "abciiidef";
		for (int i = 0; i <= s.length() - 3; i++) {
			System.out.println(s.substring(i, i + 3));
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : "aeoui".toCharArray()) {
			map.put(c, 0);
		}
		System.out.println(map);
	}

}
