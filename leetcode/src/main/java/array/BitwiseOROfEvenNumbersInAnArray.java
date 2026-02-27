package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/

    Cho một mảng số nguyên nums. Hãy trả về kết quả phép OR theo từng
    bit (bitwise OR) của tất cả các số chẵn trong mảng.

    Nếu trong nums không có số chẵn nào, hãy trả về 0.
 */
public class BitwiseOROfEvenNumbersInAnArray {

//    public int evenNumberBitwiseORs(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            if ((num & 1) == 0) {
//                result |= num;
//            }
//        }
//        return result;
//    }

    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                result |= num;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        assertEquals(6, evenNumberBitwiseORs(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void test2() {
        assertEquals(0, evenNumberBitwiseORs(new int[]{7, 9, 11}));
    }

}
