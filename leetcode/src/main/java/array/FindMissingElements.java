package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-missing-elements/
 *
 * Cho một mảng số nguyên không trùng nhau. Ban đầu nó chứa đầy đủ các số
 * trong một khoảng liên tiếp, nhưng một số số đã bị thiếu. Số nhỏ nhất và
 * lớn nhất của khoảng vẫn có trong mảng.
 *
 * Hãy trả về danh sách tăng dần các số bị thiếu trong khoảng đó; nếu không
 * thiếu số nào thì trả về danh sách rỗng.
 */
public class FindMissingElements {

    public List<Integer> findMissingElements_OK(int[] nums) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(num);
        int prev = pq.poll();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            // Add all numbers between prev and curr
            for (int x = prev + 1; x < curr; x++) {
                result.add(x);
            }
            prev = curr;
        }
        return result;
    }

    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            // If there's a gap
            for (int x = prev + 1; x < curr; x++) {
                result.add(x);
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(3), findMissingElements(new int[]{1, 4, 2, 5}));
        assertIterableEquals(List.of(), findMissingElements(new int[]{7, 8, 6, 9}));
    }

}
