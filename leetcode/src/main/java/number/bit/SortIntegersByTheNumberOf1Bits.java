package number.bit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description

    Cho mảng số nguyên, sắp xếp lại theo số lượng bit khi biểu diễn nhị phân. Nếu 2
    số bằng nhau thì so sánh bằng giá trị trong thập phân.
 */
public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits0(int[] arr) {
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

    public int[] sortByBits1(int[] arr) {
        return Arrays.stream(arr) // to IntStream
                .boxed() // to Stream<Integer>
                .sorted(Comparator // Call comparator
                        .comparingInt(Integer::bitCount) // sort by bit count
                        .thenComparingInt(Integer::intValue) // sort by decimal value
                )
                .mapToInt(Integer::intValue) // to IntStream
                .toArray();
    }

    public int[] sortByBits(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    // Tạo bộ so sánh
    private int bitCompare(int a, int b) {
        int bitA = Integer.bitCount(a);
        int bitB = Integer.bitCount(b);
        return bitA != bitB ? bitA - bitB : a - b;
    }

    private void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        int pivot = nums[(left + right) / 2];

        while (i <= j) {
            while (bitCompare(nums[i], pivot) < 0) {
                i++;
            }
            while (bitCompare(nums[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(nums, left, j);
        }
        if (i < right) {
            quickSort(nums, i, right);
        }
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
