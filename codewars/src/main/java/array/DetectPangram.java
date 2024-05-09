package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/545cedaa9943f7fe7b000048/
 *
 * Một chuỗi gọi là 'pangram' nếu nó chưa tất cả các ký tự tự a-z (ignore case)
 */
public class DetectPangram {

    public boolean check0(String input) {
        boolean[] mark = new boolean[26];
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) { // 'a' <= c && c <= 'c'
                mark[c - 'a'] = true;
            }
        }
        // System.out.println("mark = " + Arrays.toString(mark));
        for (boolean b : mark) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public boolean check(String input) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!input.toLowerCase().contains("" + c)) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void doTest() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        assertEquals(true, check(pangram1));
        String pangram2 = "You shall not pass!";
        assertEquals(false, check(pangram2));
    }

}
