package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 *
 * Cho mảng số nguyên, được phép xóa k phần tử. Tìm số phần tử khác nhau còn lại trong mảng (giá trị nhỏ nhất)
 *
 * Ví dụ: [4, 5, 5] -> Xóa 4 -> Còn lại [5, 5] chỉ có 1 số duy nhất là 5 nên kết quả là 1
 */
public class LeastNumberOfUniqueIntegerAfterKRemovels {

    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        // Đếm số lần xuất hiện
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        /**
         * - Sắp xếp lại mảng theo số lần xuất hiện và ưu tiên thứ tự tự nhiên (important)
         * - Xóa k phần tử đầu tiên
         * - Đếm số lượng phần tử khác nhau còn lại
         */
        return (int) Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int compareByFrequency = numCount.get(a) - numCount.get(b);
                    return compareByFrequency != 0 ? compareByFrequency : a - b;
                })
                .skip(k)
                .distinct()
                .count();
    }

    @Test
    public void test() {
        // assertEquals(1, findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        // assertEquals(2, findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        assertEquals(3, findLeastNumOfUniqueInts(new int[]{24, 119, 157, 446, 251, 117, 22, 168, 374, 373, 323, 311, 441, 213, 120, 412, 200, 236, 328, 24, 164, 104, 331, 32, 19, 223, 89, 114, 152, 82, 456, 381, 355, 343, 157, 245, 443, 368, 229, 49, 82, 16, 373, 142, 240, 125, 8}, 41));
    }

    //    public int findLeastNumOfUniqueInts(int[] nums, int k) {
//        // Đếm số phần tử
//        Map<Integer, Integer> numCount = new HashMap<>();
//        for (int num : nums) {
//            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
//        }
//
//        // Xóa các phần tử trùng + sắp xếp lại mảng theo số lần xuất hiện
////        List<Integer> distinctNums = numCount.keySet().stream()
////                .sorted(Comparator.comparing(numCount::get))
////                .toList();
//
//        List<Integer> list = Arrays.stream(nums)
//                .boxed()
//                .sorted(Comparator.comparingInt((Integer num) -> numCount.get(num)).thenComparing(num -> num))
//                .skip(k)
//                .toList();
//
//        // System.out.println("numCount = " + numCount);
//        // System.out.println("list = " + Arrays.toString(list.toArray()));
//        // System.out.println("distinctNums = " + Arrays.toString(distinctNums.toArray()));
////        int count = 0;
////        for (int num : distinctNums) {
////            int frequency = numCount.get(num);
////            if (k >= frequency) {
////                k -= frequency;
////            } else {
////                count++;
////            }
////        }
////        return count;
//        return new HashSet<>(list).size();
//    }

}
