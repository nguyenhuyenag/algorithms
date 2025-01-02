package array.splitarray;

import java.util.*;

public class SplitArray {

    /**
     * Chia mảng thành n mảng con
     */
    public static <T> List<List<T>> splitList(List<T> list, int n) {
        // @formatter:off
        List<List<T>> result = new ArrayList<>();
        int partitionSize   = list.size() / n;    // Dự đoán kích thước 1 list con
        int remaining       = list.size() % n;    // Phần dư
        int currentIndex = 0;
        for (int i = 0; i < n; i++) {
            int subListSize = partitionSize;    // Kích thước 1 list con thực tế
            if (remaining > 0) {
                remaining--;
                subListSize++;
            }
            // int subListSize = partitionSize + (remaining-- > 0 ? 1 : 0);
            result.add(list.subList(currentIndex, currentIndex + subListSize));
            currentIndex += subListSize;
        }
        return result;
        // @formatter:on
    }

    /**
     * Chia 1 mảng thành các (len % k) mảng con có k phần tử tăng dần
     *
     *  [1,2,3,3,4,4,5,6]            -> [1,2,3,4], [3,4,5,6]
     *  [3,2,1,2,3,4,3,4,5,9,10,11]  -> [1,2,3] , [2,3,4] , [3,4,5], [9,10,11]
     */
    public static List<List<Integer>> splitArray(int[] nums, int k) {
        if (nums.length % k != 0) {
            System.out.println("The array cannot be divided into sets of size k");
            return null;  // The array cannot be divided into sets of size k
        }
        Arrays.sort(nums);  // Sort the array
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> numFrequency = new HashMap<>();
        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (numFrequency.get(num) > 0) {
                List<Integer> currentSet = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;
                    if (numFrequency.getOrDefault(nextNum, 0) > 0) {
                        currentSet.add(nextNum);
                        numFrequency.put(nextNum, numFrequency.get(nextNum) - 1);
                    } else {
                        return null;  // The array cannot be divided into sets of size k
                    }
                }
                result.add(currentSet);
            }
        }
        System.out.println("result = " + Arrays.toString(result.toArray()));
        return result;
    }

}
