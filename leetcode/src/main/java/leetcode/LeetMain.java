package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-triangle-number/
 */
public class LeetMain {

    public static String solution(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        return new String(arr);
    }

    @Test
    public void doTest() {
        assertEquals("dlrow", solution("world"));
    }

}
