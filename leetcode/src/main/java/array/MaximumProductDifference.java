package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 *
 * Cho mảng số nguyên nums, tìm 4 số khác (i,j), (u,v) sao cho
 *              (num[i] * nums[j] - num[u] * nums[v]) => lớn nhất
 * Trả về giá trị lớn nhất này
 *              num[i] * nums[j] -> Lớn nhất -> Lớn nhất * lớn nhì
 *              num[u] * nums[v] -> Nhỏ nhất -> Nhỏ nhất * nhỏ nhì
 */
public class MaximumProductDifference {

    public int maxProductDifference0(int[] nums) {
        int max = 0, min = 10001;
        int secondMax = 0, secondMin = 10001;
        for (int num : nums) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else {
                secondMin = Math.min(num, secondMin);
            }
            if (num > max) {
                secondMax = max;
                max = num;
            } else {
                secondMax = Math.max(secondMax, num);
            }
        }
        return (max * secondMax) - (min * secondMin);
    }

    public int maxProductDifference1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
    }

    public int maxProductDifference(int[] nums) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : nums) {
            max.add(v);
            min.add(v);
        }
        return max.poll() * max.poll() - min.poll() * min.poll();
    }

    @Test
    public void doTest() {
        assertEquals(34, maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        assertEquals(64, maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }

}
