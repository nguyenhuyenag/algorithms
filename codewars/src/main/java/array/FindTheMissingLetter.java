package array;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5839edaa6754d6fec10000a2/
 *
 * Tìm ký tự còn thiếu trong mảng (tăng dần)
 */
public class FindTheMissingLetter {

    public static char findMissingLetter0(char[] arr) {
        Queue<Character> mark = new PriorityQueue<>();
        for (char c = arr[0]; c <= arr[arr.length - 1]; c++) {
            mark.add(c);
        }
        for (char c : arr) {
            Character t = mark.poll();
            if (t != null && !t.equals(c)) {
                return t;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char findMissingLetter(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Nếu 'ký tự kế tiếp' không phải là 'ký tự hiện tại + 1'
            if (arr[i] + 1 != arr[i + 1]) {
                // Thì ký tự còn thiếu là 'ký tự hiện tại + 1'
                return (char) (arr[i] + 1);
            }
        }
        return '\0';
    }

    @Test
    public void doTest() {
        assertEquals('P', findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
        assertEquals('e', findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    }

}
