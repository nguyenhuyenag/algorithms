package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/minimum-common-value/description/
 *
 * Cho 2 mảng số nguyên. Tìm phần tử chung nhỏ nhất
 */
public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> common = new ArrayList<>();
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
        if (common.isEmpty()) {
            return -1;
        }
        return Collections.min(common);
    }

    @Test
    public void test() {
        assertEquals(2, getCommon(new int[]{1, 2, 4}, new int[]{2, 3}));
    }

}
