package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class MainLeet {

    public static int numSquares_0(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }

    public static int numSquares_1(int n) {
        if (n <= 0) return 0;
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 1; j * j <= current; j++) {
                    int remainder = current - j * j;
                    if (remainder == 0) {
                        return count;
                    }
                    queue.add(remainder);
                    System.out.println(queue);
                }
            }
        }
        return -1;
    }

    public static int numSquares(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int i = (int) Math.sqrt(num); i >= 1; i--) {
                int remainder = num - i * i;
                if (remainder >= 0) {
                    stack.push(i * i);
                    // stack.push(remainder);
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(3, numSquares(12));
        // assertEquals(2, numSquares(13));
        // assertEquals(2, numSquares(2));
    }

}
