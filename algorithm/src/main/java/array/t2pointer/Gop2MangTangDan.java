package array.t2pointer;

import java.util.Arrays;

/**
 * Chủ đề: Two pointer
 *
 * Gộp 2 mảng tăng dần
 */
public class Gop2MangTangDan {

    public static void merge2SortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1 + len2];

        int i = 0, j = 0, p = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                result[p++] = nums1[i++];
            } else {
                result[p++] = nums2[j++];
            }
            // result[p++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        // Sao chép các phần tử còn lại của dãy nums1 (nếu có)
        while (i < len1) {
            result[p++] = nums1[i++];
        }

        // Sao chép các phần tử còn lại của dãy nums2 (nếu có)
        while (j < len2) {
            result[p++] = nums2[j++];
        }

        System.out.println(Arrays.toString(result));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            answer[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) {
            answer[k++] = a[i++];
        }
        while (j < b.length) {
            answer[k++] = b[j++];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 8, 10};
        int[] b = {2, 6, 7, 12, 14, 15};
        merge2SortedArrays(a, b);
    }

}
