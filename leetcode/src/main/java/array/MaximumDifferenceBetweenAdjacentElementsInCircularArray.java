package array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/

    Giả sử mảng là vòng tròn, tìm khoảng cách lớn nhất giữa hai phần tử liền kề.
 */
public class MaximumDifferenceBetweenAdjacentElementsInCircularArray {

    public int maxAdjacentDistance(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            int n2 = nums[(i + 1) % nums.length];
            maxDistance = Math.max(maxDistance, Math.abs(n1 - n2));
        }
        return maxDistance;
    }

    @Test
    public void test1() {
        assertEquals(3, maxAdjacentDistance(new int[]{1, 2, 4}));
        assertEquals(5, maxAdjacentDistance(new int[]{-5, -10, -5}));
    }

    @Disabled
    @Test
    public void test_disable() {

    }

}
