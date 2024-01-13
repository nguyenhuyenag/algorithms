package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 *
 * Chia chuỗi thành 2 phần a, b. Trả về true nếu số nguyên âm của a, b bằng nhau
 */
public class DetermineIfStringHalvesAreAlike {

    public static boolean halvesAreAlike(String s) {
        int length = s.length();
        String a = s.substring(0, length / 2);
        String b = s.substring(length / 2);
        return countVowels(a) == countVowels(b);
    }

    private static int countVowels(String str) {
        int count = 0;
        String vovels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vovels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

//    private static boolean isVowel(char c) {
//        return "aeiouAEIOU".indexOf(c) != -1;
//    }

    @Test
    public void test() {
        // assertEquals(true, halvesAreAlike("book"));
        // assertEquals(false, halvesAreAlike("textbook"));
        assertEquals(false, halvesAreAlike("tkPAdxpMfJiltOerItiv"));
    }

}
