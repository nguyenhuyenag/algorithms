package number;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/maximum-swap/

    Cho số nguyên dương n. Có thể hoán đổi 0 hoặc 2 chữ số  trong n. Tìm số lớn nhất.

    - Sinh tất cả hoán vị của n.
    - Tìm các hoán vị mà chỉ khác với n đúng 2 vị trí hoặc 0.
    - Tìm số lớn nhất trong số đó.
 */
public class MaximumSwap {

    // 123 -> [1, 2, 3]
    public int[] toArray(int n) {
        return Integer.toString(n)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    // [1, 2, 3] -> 123
    public int toNumber(int[] arr) {
        int number = 0;
        for (int digit : arr) {
            number = number * 10 + digit;
        }
        return number;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Hai mảng chỉ có đúng 2 vị trí khác nhau
    public boolean hasExactly2Differences(int[] arr1, int[] arr2) {
        int diffCount = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i] && ++diffCount > 2) {
                return false;
            }
        }
        return diffCount == 0 || diffCount == 2;
    }

    public void permute(Set<Integer> result, int[] original, int[] currentList, int start, int end) {
        if (start == end) {
            if (hasExactly2Differences(original, currentList)) {
                result.add(toNumber(currentList));
            }
        } else {
            for (int i = start; i <= end; i++) {
                swap(currentList, start, i);
                permute(result, original, currentList, start + 1, end);
                swap(currentList, start, i);
            }
        }
    }

    public int maximumSwap(int n) {
        var digits = toArray(n);
        var clone = digits.clone(); // Mảng sẽ bị thay đổi
        Set<Integer> result = new HashSet<>();
        permute(result, digits, clone, 0, digits.length - 1);
        return Collections.max(result);
    }

    @Test
    public void test() {
        assertEquals(321, maximumSwap(123));
        assertEquals(9973, maximumSwap(9973));
    }

}
