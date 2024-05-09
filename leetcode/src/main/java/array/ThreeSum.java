package array;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Chủ đề: Two pointer
 *
 * https://leetcode.com/problems/3sum/
 *
 * Tìm ba số có tổng bằng 0
 */
public class ThreeSum {

    public List<List<Integer>> threeSum0(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        // Lưu trữ giá trị số và vị trí index tương ứng
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (!visited.add(nums[i])) continue;
            for (int j = i + 1; j < len; j++) {
                int num3 = -(nums[i] + nums[j]);
                // num3 có trong mảng và
                if (map.containsKey(num3) && map.get(num3) == i) {
                    List<Integer> ans = Arrays.asList(nums[i], nums[j], num3);
                    Collections.sort(ans);
                    result.add(ans);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }

    @Test
    public void test_array_pass() {
        // int[] arr = {0, 1, 1};
        // int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {1, 2, -2, -1};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(Arrays.toString(lists.toArray()));
    }

//    @Test
//    public void test_array_pass() {
//        List<String> actual = Arrays.asList("fee", "fi", "foe");
//        List<String> expected = Arrays.asList("fee", "fi", "foe");
//        assertIterableEquals(actual, expected);
//    }

}
