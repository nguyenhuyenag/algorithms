package array;

import java.util.Arrays;

/**
 * Duyệt 2 mảng có độ dài không bằng nhau
 *
 * Xem thêm Duyet2ChuoiKhongBangNhau.java
 */
public class Duyet2MangKhongBangNhau {

    public static void reversed(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    /**
     * Cộng từ trái qua
     */
    public static int[] fromLeft(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int max = Math.max(len1, len2);
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            int num1 = (i < len1) ? arr1[i] : 0;
            int num2 = (i < len2) ? arr2[i] : 0;
            result[i] = num1 + num2;
        }
        return result;
    }

    /**
     * Cộng từ phải qua
     */
    public static int[] fromRight_OK(int[] arr1, int[] arr2) {
        reversed(arr1);
        reversed(arr2);
        int[] result = fromLeft(arr1, arr2);
        reversed(result);
        return result;
    }

    public static int[] fromRight(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int max = Math.max(len1, len2);
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            int num1 = (i < len1) ? arr1[(len1 - 1) - i] : 0; // len1 - 1 là độ dài tối đa của mảng arr1
            int num2 = (i < len2) ? arr2[(len2 - 1) - i] : 0;
            result[max - 1 - i] = num1 + num2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8, 9};
        System.out.println("fromLeft: " + Arrays.toString(fromLeft(arr1, arr2)));
        System.out.println("fromRight: " + Arrays.toString(fromRight(arr1, arr2)));
    }

}
