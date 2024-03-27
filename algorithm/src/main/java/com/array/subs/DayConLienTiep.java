package com.array.subs;

import java.util.function.Predicate;

public class DayConLienTiep {

    public static <T> int findContiguousSubsequence(T[] arr, Predicate<T> p) {
        int maxLength = 0, currentMax = 0;
        for (T v : arr) {
            if (p.test(v)) {
                currentMax++;
            } else {
                maxLength = Math.max(maxLength, currentMax);
                currentMax = 0;
            }
        }
        return maxLength;
    }

    /**
     * Dãy con dương dài nhất
     */
    public static void findDayConDuongDaiNhat() {
        Integer[] arr = {1, 2, 3, -4, 5};
        int result = findContiguousSubsequence(arr, t -> t > 0);
        System.out.println(result);
    }

    // Giả sử "-" là khoảng trắng
    public static void findDayConKhoangTrangDaiNhat() {
        String s = "1-2-ac------BGd--kt-y-l";
        int result = findContiguousSubsequence(s.split(""), t -> t.equals("-"));
        System.out.println(result);
    }

    public static void main(String[] args) {
        // findDayConDuongDaiNhat();
        findDayConKhoangTrangDaiNhat();
    }

}
