package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/append-k-integers-with-minimal-sum/
 *
 * Chèn k số nguyên dương (không trùng nhau, không có sẵn trong mảng) vào
 * mảng sao cho tổng các phần tử của mảng nhỏ nhất.
 * Trả về tổng của k số đó.
 *
 * Input: nums = [1,4,25,10,25], k = 2. Output: 5
 *
 * => Hai số cần chèn là 2, 3.
 */
public class AppendKIntegersWithMinimalSum {

//    public long minimalKSum(int[] nums, int k) {
//        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//        int p = 0, num = 1;
//        int[] result = new int[k];
//        while (p < k) {
//            // Nếu chưa xuất hiện trong set
//            if (!seen.contains(num)) {
//                result[p++] = num;
//            }
//            num++;
//        }
//        long sum = 0;
//        for (int value : result) {
//            sum += value;
//        }
//        return sum;
//    }

    public long minimalKSum(int[] nums, int k) {
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int p = 0, num = 1;
        long sum = 0;
        while (p < k) {
            // Nếu chưa xuất hiện trong set
            if (!seen.contains(num)) {
                sum += num;
                p++;
            }
            num++;
        }
        return sum;
    }

    @Test
    public void test() {
        // assertEquals(5, minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
        assertEquals(25, minimalKSum(new int[]{5, 6}, 6));
    }

}
