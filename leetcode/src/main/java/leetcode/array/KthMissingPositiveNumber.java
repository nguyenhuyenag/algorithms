package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/description/
 *
 * Cho mảng đã sắp xếp, tìm phần tử thứ k trong các phần tử còn thiếu của mảng
 *
 * Example 1: For arr = [2,3,4,7,11], k = 5 then output = 9
 * The missing positive integers are [1,5,6,8,9,10,12,13,...] -> The 5th missing positive integer is 9
 *
 * Example 2: For arr = [1,2,3,4], k = 2 then output = 6
 * The missing positive integers are [5,6,7,...] -> The 2nd missing positive integer is 6
 */
public class KthMissingPositiveNumber {

//    public int findKthPositive(int[] arr, int k) {
//        for (int i : arr) {
//            if (i <= k)
//                k++;
//            else
//                break;
//        }
//        return k;
//    }

    public int findKthPositive(int[] arr, int k) {
        List<Integer> missing = new ArrayList<>();
        int i = 1; // Con trỏ đi từ 1 (số nguyên dương nhỏ nhất)
        for (int x : arr) {
            // Nếu i < x thì thêm những số <= x vào mảng, tương tự cho đến hết
            while (i < x) {
                missing.add(i++);
            }
            i++;
        }
        // Nếu mảng missing chưa có đủ k phần tử thì tiếp tục thêm vào
        while (missing.size() < k) {
            missing.add(i++);
        }
        // Trả về vị trí k-th (vì mảng đếm từ 0)
        return missing.get(k - 1);
    }

    @Test
    public void test() {
        assertEquals(9, findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        assertEquals(6, findKthPositive(new int[]{1, 2, 3, 4}, 2));
        // findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        // findKthPositive(new int[]{1, 2, 3, 4}, 2);
    }

}
