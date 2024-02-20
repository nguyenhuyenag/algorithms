package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * Cho số nguyên được biểu diễn dưới dạng mảng các chữ số và số nguyên k.
 * Trả về mảng là tổng của chúng
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm_OK(int[] nums, int k) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        BigInteger n1 = new BigInteger(builder.toString());
        BigInteger n2 = new BigInteger(Integer.toString(k));
        return n1.add(n2).toString()
                .chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public List<Integer> addToArrayForm(int[] nums, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = nums[i] + k;
            result.addFirst(sum % 10);
            k = sum / 10;
        }
        while (k > 0) {
            result.addFirst(k % 10);
            k /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(4, 5, 5), addToArrayForm(new int[]{2, 7, 4}, 181));
        // assertIterableEquals(List.of(1, 2, 3, 4), addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    }

}
