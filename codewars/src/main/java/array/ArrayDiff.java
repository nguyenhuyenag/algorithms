package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/523f5d21c841566fde000009/
 *
 * Xóa tất cả các phần từ của A có trong B
 */
public class ArrayDiff {

    public int[] arrayDiff0(int[] A, int[] B) {
        Arrays.sort(B);
        List<Integer> ans = new ArrayList<>();
        for (int x : A) {
            if (Arrays.binarySearch(B, x) < 0) {
                ans.add(x);
            }
        }
        return ans.stream().mapToInt(t -> t).toArray();
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        // Base list
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        // Unmodifiable list
        List<Integer> listB = Arrays.stream(b).boxed().toList();
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{}, arrayDiff(new int[]{}, new int[]{1, 2}));
        assertArrayEquals(new int[]{2}, arrayDiff(new int[]{1, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1}, arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
        assertArrayEquals(new int[]{2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1, 2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{}));
    }

}
