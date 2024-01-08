package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
//        int len = nums.length;
//        Set<List<Integer>> result = new HashSet<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            int n1 = nums[i];
//            for (int j = i + 1; j < len; j++) {
//                if (i != j) {
//                    int n2 = nums[j];
//                    int n3 = -(n1 + n2);
//                    if (map.containsKey(n3)) {
//                        int k = map.get(n3);
//                        if (j != k && k != i) {
//                            List<Integer> ans = Arrays.asList(n1, n2, n3);
//                            // Collections.sort(ans);
//                            result.add(ans);
//                        }
//                    }
//                }
//            }
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], i);
//            }
//        }
//        Set<List<Integer>> sortedList = new HashSet<>();
//
//        for (List<Integer> innerList : result) {
//            List<Integer> sortedInnerList = new ArrayList<>(innerList);
//            Collections.sort(sortedInnerList);
//            sortedList.add(sortedInnerList);
//        }
//
//        return new ArrayList<>(sortedList);

        Set<List<Integer>> result = new HashSet<>();

        Set<Integer> duplicatedSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (!duplicatedSet.add(nums[i])) continue;
            for (int j = i + 1; j < len; j++) {
                int num3 = -(nums[i] + nums[j]);
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

    @Test
    public void test_array_pass() {
        // int[] arr = {-1, 0, 1, 2, -1, -4};
        // int[] arr = {0, 1, 1};
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
