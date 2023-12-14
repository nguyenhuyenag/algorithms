package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class MaxSubstringWithoutRepeat {
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		String[] arr = s.split("");
		int n = s.length();
		for (int i = 0; i < n; i++) {				// với mỗi i
			StringBuilder str = new StringBuilder(arr[i]);
			for (int j = i + 1; j < n; j++) { 		// ta thêm các ký tự phía sau i để tạo ra chuỗi con
				if (str.indexOf(arr[j]) == -1) {	
					str.append(arr[j]); 			// nếu chưa có thì
				} else {
					break;							// nếu đã có thì thoát
				}
			}
			max = Math.max(max, str.length());		// chạy hết chuỗi hoặc bị thoát, so sánh str với max
		}
		return max;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		assertEquals(1, lengthOfLongestSubstring(" "));
		assertEquals(0, lengthOfLongestSubstring(""));
		assertEquals(2, lengthOfLongestSubstring("au"));
	}

}
