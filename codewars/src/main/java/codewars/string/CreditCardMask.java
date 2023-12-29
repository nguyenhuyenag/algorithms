package codewars.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/
 *
 * Mã hóa một chuỗi ký trừ 4 ký tự cuối
 *
 * "4556364607935616" --> "############5616"
 *      "64607935616" -->      "#######5616"
 *                "1" -->                "1"
 *                 "" -->                 ""
 */
public class CreditCardMask {

    public static String maskify(String str) {
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
        assertEquals("#######5616",      maskify(     "64607935616"));
        assertEquals("1",                maskify(               "1"));
        assertEquals("",                 maskify(                ""));
        assertEquals("##ippy",           maskify(           "Skippy"));
    }

    /*-
     * https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/
     *
     *      "abcd"      ->   "A-Bb-Ccc-Dddd"
     *      "RqaEzty"   ->   "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
     *      "cwAt"      ->   "C-Ww-Aaa-Tttt"
     */
    public static class Mumbling {

        public static String repeat(char c, int n) {
            return Character.toUpperCase(c) + String.valueOf(c).toLowerCase().repeat(n - 1);
        }

        public static String accum(String input) {
            String[] words = input.split("");
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                words[i] = repeat(c, i + 1);
            }
            return String.join("-", words);
        }

        @Test
        public void test() {
            assertEquals("A-Bb-Ccc-Dddd", accum("abcd"));
            assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", accum("RqaEzty"));
            assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", accum("ZpglnRxqenU"));
            // assertEquals("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb", accum("NyffsGeyylB"));
            // assertEquals("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu", accum("MjtkuBovqrU"));
            // assertEquals("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm", accum("EvidjUnokmM"));
            // assertEquals("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc", accum("HbideVbxncC"));
        }

    }
}
