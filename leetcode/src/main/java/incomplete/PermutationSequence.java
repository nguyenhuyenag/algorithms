package incomplete;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/permutation-sequence/

    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order, we get the
    following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"

    Given n and k, return the kth permutation sequence.

    Example:  n = 3, k = 3 -> "213"
 */
public class PermutationSequence {

    public String ofString(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int v : list) {
            builder.append(v);
        }
        return builder.toString();
    }

    public void backtrack(List<List<Integer>> result,
                          List<Integer> currentList, int left, int right) {
        if (left == right) {
            result.add(new ArrayList<>(currentList)); // Add a new list instance
        } else {
            for (int i = left; i <= right; i++) {
                Collections.swap(currentList, left, i);
                backtrack(result, currentList, left + 1, right);
                Collections.swap(currentList, left, i); // backtrack
            }
        }
    }

    public String getPermutation(int n, int k) {
        var list = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, list, 0, list.size() - 1);
        return ofString(result.get(k - 1));
    }

    @Test
    public void test() {
        // assertEquals("213", getPermutation(3, 3));
        assertEquals("2314", getPermutation(4, 9));
    }

}
