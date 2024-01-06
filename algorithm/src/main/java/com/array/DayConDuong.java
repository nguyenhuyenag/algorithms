package com.array;

import com.util.RandomUtils;

import java.util.Arrays;

/*-
 * - Tìm dãy con dương (dãy chỉ toàn số dương) dài nhất trong mảng
 *
 * - cmax là chiều dài dãy con dương hiện tại, max là chiều dài dãy con dương dài nhất.
 *
 * - Duyệt mảng, với mỗi phần tử x ta kiểm tra
 *
 *      + nếu x > 0 thì tăng cmax lên 1 đơn vị
 *      + Nếu x <= 0 thì ta gán max = MAX(max, cmax), và đặt cmax = 0.
 *
 * - Kết quả: MAX(max, cmax)
 */
public class DayConDuong {

    public static void findDayConDuong(int[] arr) {
        int cmax = 0, max = 0;
        for (int x : arr) {
            if (x > 0) {
                cmax++;
            } else {
                max = Math.max(max, cmax);
                cmax = 0;
            }
        }
        System.out.println(Math.max(max, cmax));
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.randomArrays();
        System.out.println("arr = " + Arrays.toString(arr));
        findDayConDuong(arr);
    }

}
