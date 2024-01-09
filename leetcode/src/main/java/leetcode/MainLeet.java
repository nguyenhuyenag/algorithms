package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 */
public class MainLeet {

//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            int l = 0, r = len - 1;
//            int prod = 1;
//            while (l < i) {
//                prod *= nums[l];
//                l++;
//            }
//            while (i < r) {
//                prod *= nums[r];
//                r--;
//            }
//            ans[i] = prod;
//        }
//        return ans;
//    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        // Tính tích bên trái
        int leftProd = 1;
        for (int i = 0; i < len; i++) {
            ans[i] = leftProd;
            leftProd *= nums[i];
        }

        // Tính tích bên phải và nhân với tích bên trái
        int rightProd = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= rightProd;
            rightProd *= nums[i];
        }

        return ans;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

}
