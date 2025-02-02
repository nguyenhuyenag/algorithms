package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/next-greater-element-iii/

    Cho số nguyên n, tìm số nhỏ nhất có cùng chữ số và > n.
 */
public class NextGreaterElementIII {

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

    public void permute(final int N, int[] result, int[] currentList, int start, int end) {
        if (start == end) {
            int num = toNumber(currentList);
//            if (num > N) {
//                if (result[0] == -1) {
//                    result[0] = num;
//                } else {
//                    if (result[0] > num) {
//                        result[0] = num;
//                    }
//                }
//            }
            // Tìm được số num > N và:
            //  + result chưa cập nhập (result[0] == -1)
            //  + result[0] < num
            if (num > N && (result[0] == -1 ||  num < result[0])) {
                result[0] = num;
            }
        } else {
            for (int i = start; i <= end; i++) {
                swap(currentList, start, i);
                permute(N, result, currentList, start + 1, end);
                swap(currentList, start, i);
            }
        }
    }

    public int nextGreaterElement(int n) {
        var digits = toArray(n);
        int[] result = {-1};
        permute(n, result, digits, 0, digits.length - 1);
        return result[0];
    }

    @Test
    public void test() {
        assertEquals(21, nextGreaterElement(12));
        assertEquals(-1, nextGreaterElement(21));
        assertEquals(1243, nextGreaterElement(1234));
        assertEquals(13222344, nextGreaterElement(12443322));
    }

}
