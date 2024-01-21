package leetcode;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * Cho mảng đã sắp xếp, tìm k số gần x nhất
 */
public class MainLeet {

    // Function to generate all subsets of an array with a specified size using bitwise operations
    public static void generateSubsets(int[] arr, int k) {
        int n = arr.length;
        // Total number of subsets is 2^n
        int totalSubsets = 1 << n;
        // Iterate through all possible subsets
        for (int i = 0; i < totalSubsets; i++) {
            // Count the number of set bits in the current subset bitmask
            int count = Integer.bitCount(i);
            // Check if the count matches the specified size
            if (count == k) {
                System.out.print("Subset " + (i + 1) + ": {");
                // Include elements in the subset
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(arr[j] + " ");
                    }
                }
                System.out.println("}");
            }
        }
    }


//    @Test
//    public void test() {
//        String binary = Integer.toBinaryString(5);
//        for (int i = 0; i < binary.length() - 1; i++) {
//            System.out.println(binary.substring(i, i + 2));
//            if (Math.abs(binary.charAt(i) - binary.charAt(i + 2)) != 1) {
//
//            }
//        }
//    }

//    public static int findMaxProduct(int n) {
//        if (n == 2 || n == 3) {
//            return n; // Trường hợp đặc biệt khi n là 2 hoặc 3
//        }
//        int countOf3 = n / 3; // Đếm số 3
//        int remainder = n % 3; // Còn dư
//        if (remainder == 1) {
//            // Nếu còn dư 1, thì lấy một số 3 và còn lại là 4
//            countOf3--;
//            remainder += 3;
//        }
//        // Số lớn nhất sẽ được tạo ra bằng cách sử dụng countOf3 số 3 và remainder số 1 hoặc 2
//        int maxProduct = (int) Math.pow(3, countOf3) * (int) Math.pow(2, remainder / 2);
//        return maxProduct;
//    }
//
//    public static void main(String[] args) {
//        int n = 10; // Thay đổi giá trị n theo nhu cầu
//        int maxProduct = findMaxProduct(n);
//        System.out.println("Số lớn nhất bằng tích của các số nguyên dương có tổng bằng " + n + " là: " + maxProduct);
//    }

}
