package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] nums, int k) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        BigInteger x = new BigInteger(builder.toString());
        BigInteger y = new BigInteger(Integer.toString(k));
        // System.out.println("num = " + num);
        return String.valueOf(x.add(y).toString())
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
        // System.out.println("collect = " + collect);
        // return collect;
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(1, 2, 3, 4), addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    }

}
