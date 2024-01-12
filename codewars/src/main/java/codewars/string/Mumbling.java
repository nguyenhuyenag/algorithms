package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/
 *
 *      "abcd"      ->   "A-Bb-Ccc-Dddd"
 *      "RqaEzty"   ->   "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
 *      "cwAt"      ->   "C-Ww-Aaa-Tttt"
 */
public class Mumbling {

    public static String createWord(char c, int n) {
        return Character.toUpperCase(c) + String.valueOf(c).toLowerCase().repeat(n - 1);
    }

//    public static String accum(String input) {
//        String[] words = input.split("");
//        for (int i = 0; i < words.length; i++) {
//            char c = input.charAt(i);
//            words[i] = createWord(c, i + 1); // 1, 2, 3,...
//        }
//        return String.join("-", words);
//    }

    public static String accum(String str) {
        StringJoiner joiner = new StringJoiner("-");
        for (int i = 0; i < str.length(); i++) {
            String word = createWord(str.charAt(i), i + 1);
            joiner.add(word);
        }
        return joiner.toString();
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

