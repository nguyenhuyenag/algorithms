package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class MainLeet {

//    public int maxArea(int[] arr) {
//        int maxArea = 0;
//        int l = 0, r = arr.length - 1;
//        while (l < r) {
//            int width = r - l;
//            int height = Math.min(arr[l], arr[r]);
//            int area = height * width;
//            maxArea = Math.max(area, maxArea);
//            // Cột trái đỏ < phải đỏ thì dời trái
//            if (arr[l] < arr[r]) {
//                l++;
//            } else if (arr[l] > arr[r]) {
//                r--;
//            } else {
//                l++;
//                r--;
//            }
//        }
//        return maxArea;
//    }

    public int maxArea(int[] arr) {
        int maxArea = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);
            if (arr[left] < arr[right]) {
                left++;
            } else if (arr[left] > arr[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        assertEquals(1, maxArea(new int[]{1, 1}));
        assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(24, maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
        assertEquals(17, maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

}
