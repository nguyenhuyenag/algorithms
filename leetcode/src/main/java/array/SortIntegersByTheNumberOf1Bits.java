package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description

    Cho mảng số nguyên, sắp xếp lại theo số lượng bit khi biểu diễn nhị phân. Nếu 2
    số bằng nhau thì so sánh bằng giá trị trong thập phân.
 */
public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits1(int[] arr) {
        return Arrays.stream(arr) // to IntStream
                .boxed() // to Stream<Integer>
                .sorted((a, b) -> {
                    int countA = Integer.bitCount(a);
                    int countB = Integer.bitCount(b);
                    if (countA == countB) return a.compareTo(b); // if bit count is the same, sort by decimal value
                    return countA - countB; // sort by bit count
                }) // sort by bit count
                .mapToInt(Integer::intValue) // to IntStream
                .toArray();
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr) // to IntStream
                .boxed() // to Stream<Integer>
                .sorted(Comparator // Call comparator
                        .comparingInt(Integer::bitCount) // sort by bit count
                        .thenComparingInt(Integer::intValue) // sort by decimal value
                )
                .mapToInt(Integer::intValue) // to IntStream
                .toArray();
    }

    @Test
    public void test1() {
        int[] in = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] out = new int[]{0, 1, 2, 4, 8, 3, 5, 6, 7};
        assertArrayEquals(out, sortByBits(in));
    }

    @Test
    public void test2() {
        int[] in = new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] out = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        assertArrayEquals(out, sortByBits(in));
    }

}
