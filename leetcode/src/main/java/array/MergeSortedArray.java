package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Cho mảng nums1 gồm m + n phần tử. Với m phần tử khác 0 được sắp xếp ở
 * đầu mảng và n phần tử 0 được đặt ở cuối mảng.
 *
 * Cho mảng nums2 có kích thước n được sắp xếp.
 *
 * Gộp nums2 vào nums1 bằng cách thay các số 0 trong nums1 bởi các phần tử
 * trong nums2 sau cho nums1 cũng là mảng được sắp xếp.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
