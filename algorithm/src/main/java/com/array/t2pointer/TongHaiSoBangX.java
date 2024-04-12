package com.array.t2pointer;

/**
 * Cho mảng đã sắp xếp, tìm 2 số có tổng bằng x cho trước
 */
public class TongHaiSoBangX {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 10, 12, 15};
        int target = 16;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                System.out.println(arr[i] + "," + arr[j]);
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

}
