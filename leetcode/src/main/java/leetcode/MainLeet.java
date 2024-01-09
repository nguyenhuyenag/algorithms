package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class MainLeet {

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int n2 = target - nums[i];
//            // Nếu n2 có trong map -> lấy ra chỉ số
//            if (map.containsKey(n2)) {
//                int j = map.get(n2);
//                return nums[i] >= nums[j] ? new int[]{j + 1, i + 1} : new int[]{i + 1, j + 1};
//            }
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], i);
//            }
//        }
//        return new int[]{0, 0};
//    }

    @Test
    public void test() {
        StringBuilder str = new StringBuilder("OP");
        int l = 0, r = str.length() - 1;
        while (l < r) {
            System.out.println(str.charAt(l) + ", " +  str.charAt(r));
            l++;
            r--;
        }
    }

}
