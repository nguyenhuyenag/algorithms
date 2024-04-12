package com.string;

/**
 * Các phép toán đếm trên mảng
 */
public class CounterCharacter {

    /**
     * Đếm số lần xuất hiện của ký tự trong chuỗi
     */
    public int frequency(String s, char target) {
        return s.chars().filter(t -> t == target).sum();
    }

}
