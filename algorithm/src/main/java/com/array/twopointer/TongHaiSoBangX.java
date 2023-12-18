package com.array.twopointer;

/**
 * Cho mảng không giảm, tìm 2 số có tổng bằng x cho trước
 */
public class TongHaiSoBangX {

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 8, 10, 12, 15};
        int i = 0, j = a.length - 1;
        int x = 16;
        while (i < j) {
            if (a[i] + a[j] == x) {
                System.out.println(a[i] + "," + a[j]);
            }
            if (a[i] + a[j] < x) {
                i++;
            } else {
                j--;
            }
        }
    }

}
