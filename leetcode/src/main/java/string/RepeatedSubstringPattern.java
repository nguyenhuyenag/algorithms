package string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Kiểm tra chuỗi s có phải là chuỗi lặp của một chuỗi nào đó không
 *
 *      "ababab"    =    ab x 3   -> true
 */
public class RepeatedSubstringPattern {

//	public boolean repeatedSubstringPattern_OK(String input) {
//		int len = input.length();
//		// Chỉ lặp đến len/2, vì nếu vượt quá thì chuỗi mới sẽ dài hơn chuỗi gốc
//		for (int i = 1; i <= len / 2; i++) {
//			if (len % i == 0) {
//				String substring = input.substring(0, i);
//				StringBuilder repeated = new StringBuilder();
//				// Repeat the substring to check if it can construct the original string
//				for (int j = 0; j < len / i; j++) {
//					repeated.append(substring);
//				}
//				if (repeated.toString().equals(input)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // Chỉ lặp đến n/2, vì nếu vượt quá thì chuỗi repeat sẽ dài hơn chuỗi gốc
        for (int i = 1; i <= n / 2; i++) {
            //  Nếu n != k * i thì không cần lặp
            if (n % i != 0) continue;
            String sub = s.substring(0, i);
            if (s.equals(sub.repeat(n / i))) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(false, repeatedSubstringPattern("a"));
        assertEquals(false, repeatedSubstringPattern("aba"));
        assertEquals(true, repeatedSubstringPattern("ababab"));
    }

}
