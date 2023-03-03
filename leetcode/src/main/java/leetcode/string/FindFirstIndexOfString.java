package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FindFirstIndexOfString {

	public int strStr1(String haystack, String needle) {
		int l1 = haystack.length();
		int l2 = needle.length();
		System.out.println("l1 = " + l1 + ", l2 = " + l2);
		for (int i = 0; i <= l1 - l2; i++) {
			String sub = haystack.substring(i, i + l2);
			System.out.println("i = " + i + ", sub = " + sub);
			if (needle.equals(sub)) {
				return i;
			}
		}
		return -1;
	}

	public int strStr2(String haystack, String needle) {
		int index = 0;
		int l = haystack.length() - needle.length() + 1;
		while (index < l) {
			String temp = haystack.substring(index, index + needle.length());
			if (needle.equals(temp))
				return index;
			index++;
		}
		return -1;
	}

	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	@Test
	public void doTest() {
		assertEquals(strStr("a", "a"), 0);
		assertEquals(strStr("hello", "ll"), 2);
		assertEquals(strStr("sadbutsad", "sad"), 0);
		assertEquals(strStr("leetcode", "leeto"), -1);
	}

}
