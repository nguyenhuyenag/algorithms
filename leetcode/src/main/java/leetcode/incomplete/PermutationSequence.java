package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Example:  n = 3, k = 3 -> "213"
 */
public class PermutationSequence {

    private int count = 0;
    private String result = "";

    private void permute(List<Integer> numbers, int k, String current) {
        if (numbers.isEmpty()) {
            count++;
            if (count == k) {
                result = current;
            }
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                List<Integer> remaining = new ArrayList<>(numbers);
                int digit = remaining.remove(i);
                permute(remaining, k, current + digit);
            }
        }
    }

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        permute(numbers, k, "");
        return result;
    }

    @Test
    public void test() {
        assertEquals("213", getPermutation(3, 3));
        assertEquals("2314", getPermutation(4, 9));
    }

}
