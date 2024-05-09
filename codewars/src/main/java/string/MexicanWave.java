package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/
 *
 * wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}
 */
@SuppressWarnings("unused")
public class MexicanWave {

//	public String[] wave(String s) {
//		StringBuilder str = new StringBuilder(s);
//		int n = s.replaceAll("\\s+", "").length();
//		String[] arr = new String[n];
//		int j = 0;
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if (Character.isLetter(c)) {
//				str.setCharAt(i, Character.toUpperCase(c));
//				arr[j] = str.toString();
//				str.setCharAt(i, Character.toLowerCase(c));
//				j++;
//			}
//		}
//		return arr;
//	}

//    public static String upperByIndex(String s, int i) {
//        StringBuilder builder = new StringBuilder(s);
//        char ch = s.charAt(i);
//        builder.setCharAt(i, Character.toUpperCase(ch));
//        return builder.toString();
//    }
//
//    public String[] wave(String s) {
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetter(s.charAt(i))) {
//                String word = upperByIndex(s, i);
//                result.add(word);
//            }
//        }
//        String[] ans = result.toArray(String[]::new);
//        System.out.println("ans = " + Arrays.toString(ans));
//        return ans;
//    }

    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                list.add(str.substring(0, i) + Character.toUpperCase(ch) + str.substring(i + 1));
            }
        }
        return list.toArray(String[]::new);
    }

    @Disabled
    @Test
    public void basicTest4() {
        String[] result = {"Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS"};
        // assertArrayEquals("it should return '" + Arrays.toString(result) + "'",
        // result, wave("two words"));
    }

    @Disabled
    @Test
    public void basicTest1() {
        String[] result = new String[]{"Hello", "hEllo", "heLlo", "helLo", "hellO"};
        // assertArrayEquals("it should return '" + Arrays.toString(result) + "'",
        // result, wave("hello"));
    }

    @Disabled
    @Test
    public void basicTest2() {
        String[] result = new String[]{"Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs",
                "codewaRs", "codewarS"};
        // assertArrayEquals("it should return '" + Arrays.toString(result) + "'",
        // result, wave("codewars"));
    }

    @Disabled
    @Test
    public void basicTest3() {
        String[] result = new String[]{};
        // assertArrayEquals("it should return '" + Arrays.toString(result) + "'",
        // result, MexicanWave.wave(""));
    }

    @Test
    public void basicTest5() {
        String[] result = {" Gap ", " gAp ", " gaP "};
        assertArrayEquals(result, wave(" gap "));
    }

}
