package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/shifting-letters/
 */
public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        for (int v : shifts) {
            v %= 26;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) ((int) arr[i] + v);
            }
        }
        return new String(arr);
    }

    @Test
    public void test() {
        assertEquals("rpl", shiftingLetters("abc", new int[]{3, 5, 9}));
    }

}
