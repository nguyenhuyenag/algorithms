package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Chủ đề: Two pointer
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Cho mảng chiều cao, tìm 2 điểm mà diện tích nước trong đó là nhiều nhất
 */
public class ContainerWithMostWater {

    public int maxArea(int[] arr) {
        int maxArea = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int width = right - left; // Chiều rộng
            int hight = Math.min(arr[left], arr[right]); // Chiều cao
            int area = width * hight; // Tính diện tích
            maxArea = Math.max(maxArea, area); // Tìm diện tích lớn nhất
            // Dời con trỏ
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
