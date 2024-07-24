package array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CacPhepToanTrenMang {

    /**
     * Gộp 2 mảng (System.arraycopy() thường thực hiện sao chép nhanh chóng
     * hơn so với vòng lặp thông thường)
     */
    public void mergeArray_1(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] result = new int[len1 + len2];
        System.arraycopy(nums1, 0, result, 0, len1);
        System.arraycopy(nums2, 0, result, len1, len2);
        System.out.println("c = " + Arrays.toString(result));
    }


    public int[] mergeArray_2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int pointer = 0;
        for (int num : nums1) {
            result[pointer++] = num;
        }
        for (int num : nums2) {
            result[pointer++] = num;
        }
        return result;
    }

    /**
     * Tìm phần tử chung của 2 mảng
     *
     * Use retainAll() method to find common elements
     * set1.retainAll(set2);
     * System.out.println("Common elements- " + set1);
     */
    public Set<Integer> intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> common = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                common.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    /*-
     * Tìm các ký tự chung của mảng các chuỗi (có phần tử trùng nhau)
     *
     *  ["bella","label","roller"] -> ["e", "l", "l"]
     */
    public List<String> commonChars(String[] words) {
        // [{a=1, b=1, e=1, l=2}, {a=1, b=1, e=1, l=2}, {r=2, e=1, l=2, o=1}]
        List<Map<Character, Integer>> listOfMaps = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            listOfMaps.add(map);
        }
        // Kết quả
        List<String> commons = new ArrayList<>();
        // Các ký tự duy nhất trong chuỗi đầu tiên
        Set<Character> charOfFirstItem = listOfMaps.get(0).keySet();
        for (char ch : charOfFirstItem) {
            int min = Integer.MAX_VALUE;
            // Kiểm tra 'ch' có phải là ký tự chung của mọi phần tử hay không?
            for (Map<Character, Integer> map : listOfMaps) {
                // -> Nếu không
                if (!map.containsKey(ch)) {
                    min = 0; // Gán min = 0 để vòng lặp phía dưới ko chạy (có thể xem nó là flag = false)
                    break;
                } else { // Nếu có
                    min = Math.min(min, map.get(ch));
                }
            }
            // Lấy kết quả, ví dụ [{a=1,b=2}, {a=2,c=1}] -> {a=1} là phần tử chung
            for (int i = 0; i < min; i++) {
                commons.add(String.valueOf(ch));
            }
        }
        return commons;
    }

    /*-
     * Tìm các phần tử khác nhau của 2 mảng
     *
     *      [1,2,3], [2,4,6] -> [[1,3],[4,6]]
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));

        // Tìm hiệu nums1 - nums2
        Set<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);
        result.add(new ArrayList<>(diff1));

        // Tìm hiệu nums2 - nums1
        Set<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);
        result.add(new ArrayList<>(diff2));

        return result;
    }

    /**
     * Check duplicate 1
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check duplicate 2
     */
    public boolean containsDuplicate_2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    @Disabled
    @Test
    public void testIntersect() {
        // int[] arr = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Set<Integer> intersect = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersect.toArray()));
    }

    @Test
    public void testMerge() {
        int[] A = {1, 2, 3, 4};
        int[] B = {5, 6, 7};
    }

}
