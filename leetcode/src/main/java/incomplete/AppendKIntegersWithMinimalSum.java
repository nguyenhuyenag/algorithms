package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/append-k-integers-with-minimal-sum/

    Chèn k số nguyên dương (không trùng nhau, không có sẵn trong mảng) vào mảng
    sao cho tổng các phần tử của mảng nhỏ nhất. Trả về tổng của k số đó.

    Input: nums = [1, 4, 25, 10, 25], k = 2. Output: 5

    => Hai số cần chèn là 2, 3.
 */
public class AppendKIntegersWithMinimalSum {

    public long minimalKSum(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        // Hàng đợi các số khác nhau của mảng nums
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (!seen.contains(num)) {
                pq.add(num);
                seen.add(num);
            }
        }
        int num = 1;
        long sum = 0;
        while (k > 0) {
            // num không phải là số ở đỉnh -> nó không có trong mảng
            if (!pq.isEmpty() && pq.peek() == num) {
                pq.poll();
            } else {
                sum += num;
                k--;
            }
            num++;
        }
        return sum;
    }

    @Test
    public void test() {
        // assertEquals(25, minimalKSum(new int[]{5, 6}, 6));
        // assertEquals(5, minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
        assertEquals(5, minimalKSum(new int[]{44}, 91834962)); // TLE
    }

//        public long minimalKSum_OK(int[] nums, int k) {
//        Arrays.sort(nums);
//        long sum = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            // Nếu num chưa có trong set và num <= k
//            if (set.add(num) && num <= k) {
//                k++;
//                sum += num;
//            }
//        }
//        long result = (long) k * (k + 1) / 2;
//        return result - sum;
//    }

//        public long minimalKSum_OK(int[] nums, int k) {
//        int prev = -1; // Giá trị của số trước đó
//        long result = (long) k * (k + 1) / 2; // Tổng 1 -> n = n*(n + 1) / 2
//        Arrays.sort(nums);
//        for (int num : nums) {
//            if (prev != num && k >= num) {
//                result -= num;
//                result += ++k;
//            } else if (k < num) {
//                break;
//            }
//            prev = num;
//        }
//        return result;
//    }

}
