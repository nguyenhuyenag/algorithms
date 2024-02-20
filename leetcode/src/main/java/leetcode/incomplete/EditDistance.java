package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[] mark = new int[26];
        word1.chars().forEach(c -> mark[c - 'a']++);
        word2.chars().forEach(c -> mark[c - 'a']--);
        System.out.println("mark = " + Arrays.toString(mark));
//        int sum
//        for (int x : mark) {
//            if (x > 0) {
//                System.out.println(x);
//            }
//        }
        // Calculate the total number of operations needed
        int operations = 0;
        for (int count : mark) {
            operations += Math.abs(count);
        }

        return operations;
    }

    @Test
    public void test() {
        // assertEquals(3, minDistance("horse", "ros"));
        // assertEquals(5, minDistance("intention", "execution"));
        // assertEquals(0, minDistance("a", "a"));
        assertEquals(1, minDistance("a", "b"));
    }

}
