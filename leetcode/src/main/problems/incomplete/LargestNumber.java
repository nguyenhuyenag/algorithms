package incomplete;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    public String largestNumber1(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        if (array[0].equals("0")) {
            return "0";
        }
        StringBuilder largest = new StringBuilder();
        for (String s : array) {
            largest.append(s);
        }
        return largest.toString();
    }

    public static String removeLeadingZeros(StringBuilder num) {
        int len = num.length();
        int i = 0;
        while (i < len && num.charAt(i) == '0') {
            i++;
        }
        return i == len ? "0" : num.substring(i);
    }

    private static <T> void permute(Stack<BigInteger> stack, List<T> currentList, int start, int end) {
        if (start == end) {
            StringBuilder builder = new StringBuilder();
            currentList.forEach(builder::append);
            BigInteger value = new BigInteger(removeLeadingZeros(builder));
            if (stack.isEmpty()) {
                stack.push(value);
            } else if (value.compareTo(stack.peek()) > 0) {
                stack.pop();
                stack.push(value);
            }
        } else {
            for (int i = start; i <= end; i++) {
                Collections.swap(currentList, start, i);
                permute(stack, currentList, start + 1, end);
                Collections.swap(currentList, start, i);
            }
        }
    }

    public String largestNumber(int[] nums) {
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Stack<BigInteger> stack = new Stack<>();
        permute(stack, input, 0, input.size() - 1);
        return stack.pop().toString();
    }

    @Test
    public void test() {
        assertEquals("210", largestNumber(new int[]{10, 2}));
        assertEquals("9534330", largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
