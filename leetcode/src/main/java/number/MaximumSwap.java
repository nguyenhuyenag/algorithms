package number;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/maximum-swap/

    Cho số nguyên dương n. Có thể hoán đổi 0 hoặc 2 chữ số  trong n. Tìm số lớn nhất.

    - Sinh tất cả hoán vị của n.
    - Tìm các hoán vị mà chỉ khác với n 2 vị trí.
    - Tìm số lớn nhất trong số đó.
 */
public class MaximumSwap {

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Hai mảng chỉ có đúng 0 hoặc 2 vị trí khác nhau
    public boolean exactly02Different(int[] arr1, int[] arr2) {
        int diffCount = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
            }
        }
        return diffCount == 0 || diffCount == 2;
    }

    public void backtrack(int[] X, Set<Integer> result, int[] currentList, int start, int end) {
        if (start == end) {
            if (exactly02Different(X, currentList)) {
                result.add(toNumber(currentList));
            }
        } else {
            for (int i = start; i <= end; i++) {
                swap(currentList, start, i);
                backtrack(X, result, currentList, start + 1, end);
                swap(currentList, start, i);
            }
        }
    }

    public int[] toArray(int n) {
        return Integer.toString(n)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public int toNumber(int[] arr) {
        int number = 0;
        for (int digit : arr) {
            number = number * 10 + digit;
        }
        return number;
    }

    public int maximumSwap(int n) {
        var input = toArray(n); // Mảng không thay đổi
        var copy = Arrays.copyOf(input, input.length); // Mảng sẽ bị thay đổi
        Set<Integer> result = new HashSet<>();
        backtrack(input, result, copy, 0, copy.length - 1);
        return Collections.max(result);
    }

    public int maximumSwap_OK(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    @Test
    public void test() {
        assertEquals(321, maximumSwap(123));
        // assertEquals(9973, maximumSwap(9973));
    }

}
