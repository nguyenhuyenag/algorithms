package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Xem thêm: Leetcode > RotateArray.java
 */
public class ReverseArray {

    // Đảo mảng dùng vòng for
    public static void reverse1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = tmp;
        }
    }

    // Dùng mảng phụ
//    public static int[] reverse1(int[] arr) {
//        int n = arr.length;
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = arr[n - 1 - i];
//        }
//        return result;
//    }

    // Đảo mảng dùng 2 con trỏ
    public static void reverse0(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

//        public static void reverseByKGroup() {
//        int k = 3;
//        int[] arr = {1, 2, 3, 4, 5};
//        for (int i = 0; i < arr.length; i += k) {
//            int left = i;
//            int right = Math.min(i + k - 1, arr.length - 1);
//            if (right - left + 1 == k) { // Kiểm tra xem nhóm có đủ k phần tử không
//                while (left < right) {
//                    int temp = arr[left];
//                    arr[left] = arr[right];
//                    arr[right] = temp;
//                    left++;
//                    right--;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//    }

    /**
     * Đảo danh sách theo nhóm k phần tử liên tiếp không giao nhau
     *
     * [1, 2, 3, 4, 5] , k = 2 -> [2, 1, 4, 3, 5]
     *
     * [1, 2, 3, 4, 5] , k = 3 -> [3, 2, 1, 4, 5]
     *
     * Xem leetcode > ReverseNodeInKGroup.java
     */
    public static void reverseByKGroup() {
        int k = 2;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < list.size(); i += k) {
            int left = i;
            int right = Math.min(i + k - 1, list.size() - 1);
            if (right - left + 1 == k) { // Kiểm tra xem nhóm có đủ k phần tử không
                while (left < right) {
                    Collections.swap(list, left, right);
                    left++;
                    right--;
                }
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(arr));
//        reverse0(arr, 2, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        reverseByKGroup();
    }

}
