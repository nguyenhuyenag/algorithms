package leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/*-
 * Given a sentence text (a sentence is a string of space-separated words) in
 * the following format:
 * 
 * - First letter is in upper case.
 * 
 * - Each word in text are separated by a single space.
 * 
 * Your task is to rearrange the words in text such that all words are
 * rearranged in an increasing order of their lengths. If two words have the
 * same length, arrange them in their original order. Return the new text
 * following the format shown above.
 * 
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 */
public class RearrangeWords {

	public static String arrangeWords(String text) {
		String[] arr = text.toLowerCase().split(" ");
		Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
		String str = String.join(" ", arr);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	@Test
	public void test() {
		assertEquals("Is cool leetcode", arrangeWords("Leetcode is cool"));
		assertEquals("On and keep calm code", arrangeWords("Keep calm and code on"));
		assertEquals("To be or to be not", arrangeWords("To be or not to be"));
	}

}
