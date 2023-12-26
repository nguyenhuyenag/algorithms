package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/
 *
 * Mã hóa chuỗi, nếu xuất hiện 1 lần là '(', từ 2 lần thì là ')'
 *
 *      "din"      =>  "((("
 *      "recede"   =>  "()()()"
 *      "Success"  =>  ")())())"
 *      "(( @"     =>  "))(("
 */
public class WarMain {

    public static String encode(String word) {
        word = word.toLowerCase();
        int[] charCount = new int[256];
        for (char c : word.toCharArray()) {
            charCount[c]++;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (charCount[c] > 0) {
                if (charCount[c] == 1) {
                    ans.append("(");
                } else {
                    ans.append(")");
                }
            }
        }
        return ans.toString();
    }

    @Test
    public void doTest() {
        // assertEquals("(((", encode("din"));
        // assertEquals("()()()", encode("recede"));
        // assertEquals(")())())", encode("Success"));

        // assertEquals(")()())()(()()(", encode("Prespecialized"));
        assertEquals("))))())))", encode("   ()(   "));
    }

}
