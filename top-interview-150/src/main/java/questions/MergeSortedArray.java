package questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    https://leetcode.com/problems/merge-sorted-array/

    - Cho 2 mảng được sắp xếp giảm dần, với các giá trị khác 0.
    - Gộp 2 mảng vào num1 (giả sử phần dư là các số có giá trị 0).
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Duyệt từ cuối lên đầu
        int p1 = m - 1; // Con trỏ của num1
        int p2 = n - 1; // Con trỏ của num2
        int i = m + n - 1; // Con trỏ kết quả
        // Duyệt num2 để lấy phần tử gán vào num1. Dễ quản lý hơn nếu duyệt num1 vì cần quản lý p2.
        while (p2 >= 0) {
            // p1 vẫn chưa đi hết mảng và giá trị số ở num1 > số ở num2
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
    }

    public void merge_time_limit_exceeded(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while (p2 >= 0) {
            // Trong vòng lặp, phải đảm bảo p2 thay đổi (giảm) sau mỗi lần chạy.
            // Tuy nhiên lúc này, nhánh p1 < 0 không lcó -> p2 không thay đổi -> time limit exceeded.
            if (p1 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1--;
                } else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                i--;
            }
        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};   // m = 3
        int[] nums2 = {2, 5, 6};            // n = 3
        int[] res = {1, 2, 2, 3, 5, 6};
        merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(nums1, res);
    }

    @Test
    public void test2() {
        int[] nums1 = {0};      // m = 0
        int[] nums2 = {1};      // n = 1
        int[] res = {1};
        merge(nums1, 0, nums2, 1);
        Assertions.assertArrayEquals(nums1, res);
    }

}
