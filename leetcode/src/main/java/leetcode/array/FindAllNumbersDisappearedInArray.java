package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Tìm các số bị thiếu trong mảng chỉ chứa các số nguyên từ 1 -> n.
 */
public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] mark = new int[nums.length + 1];
        for (int num : nums) {
            mark[num] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(5, 6), findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        // assertIterableEquals(List.of(2), findDisappearedNumbers(new int[]{1, 1}));
    }

    //    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//        // Đánh dấu các số đã xuất hiện
//        for (int num : nums) {
//            int index = Math.abs(num) - 1;
//            if (nums[index] > 0) {
//                nums[index] = -nums[index];
//            }
//        }
//        // Thêm vào kết quả các số chưa xuất hiện
//        for (int i = 1; i <= nums.length; i++) {
//            if (nums[i - 1] > 0) {
//                result.add(i);
//            }
//        }
//
//        return result;
//    }

}
