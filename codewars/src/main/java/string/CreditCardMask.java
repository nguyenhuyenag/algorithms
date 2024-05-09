package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/
 *
 * Mã hóa một chuỗi ký trừ 4 ký tự cuối
 *
 *      "4556364607935616"  --> "############5616"
 *           "64607935616"  -->      "#######5616"
 *                     "1"  -->                "1"
 *                      ""  -->                 ""
 */
public class CreditCardMask {

    public static String maskify(String input) {
        int len = input.length();
        if (len < 4) {
            return input;
        }
        //String.concat()
        return "#".repeat(len - 4) + input.substring(len - 4);
    }

    public static String maskify0(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 4) {
                ans.append("#");
            } else {
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }

    @Test
    public void toTest() {
        assertEquals("############5616", maskify("4556364607935616"));
        assertEquals("#######5616", maskify("64607935616"));
        assertEquals("1", maskify("1"));
        assertEquals("", maskify(""));
        assertEquals("##ippy", maskify("Skippy"));
    }

}
