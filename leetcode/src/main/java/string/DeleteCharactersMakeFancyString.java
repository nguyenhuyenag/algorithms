package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/delete-characters-to-make-fancy-string/
 *
 * A fancy string is a string where no three consecutive characters are equal.
 *
 * Given a string s, delete the minimum possible number of characters from s to
 * make it fancy. Return the final string after the deletion. It can be shown
 * that the answer will always be unique.
 *
 * Input: s = "leeetcod" -> Output: "leetcode"
 */
public class DeleteCharactersMakeFancyString {

//	public static String makeFancyString0(String str) {
//		for (char c = 'a'; c <= 'z'; c++) {
//			String s = String.valueOf(c);
//			str = str.replaceAll("[" + s + "]{3,}", s + s);
//		}
//		return str;
//	}
//
//	public static String makeFancyString1(String s) {
//		StringBuilder sb = new StringBuilder();
//		int count = 1;
//		sb.append(s.charAt(0));
//		for (int i = 1; i < s.length(); i++) {
//			if (s.charAt(i - 1) != s.charAt(i))
//				count = 1;
//			else
//				count++;
//			if (count < 3)
//				sb.append(s.charAt(i));
//		}
//		return sb.toString();
//	}

//    public String makeFancyString(String s) {
//        s += "  "; // Extra 2 spaces, to handle the last 2 characters
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length() - 2; i++) { // -2 here
//            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
//                continue;
//            }
//            sb.append(s.charAt(i));
//        }
//        return sb.toString();
//    }

    public String makeFancyString(String s) {
        s += "  "; // Mở rộng thêm 2 char để xử lý 2 ký tự cuối cùng
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() - 2; i++) { // -2 here
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                continue;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("test", makeFancyString("leeeetcode"));
    }

}
