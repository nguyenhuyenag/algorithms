package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/61a498cf085ad00051190591/
 *
 * Tìm số nguyên không âm lớn nhất có tổng = k sao cho mỗi chữ số chỉ xuất hiện 1 lần
 */
public class MainWar {

//    public static void main(String[] args) {
//        int k = 23;
//        List<Integer> results = findAllMaxSumDigits(k);
//
//        if (results.isEmpty()) {
//            System.out.println("Không có số nào thỏa mãn với tổng các chữ số bằng " + k);
//        } else {
//            System.out.println("Tất cả các số thỏa mãn với tổng các chữ số bằng " + k + " là:");
//            for (int result : results) {
//                System.out.println(result);
//            }
//        }
//    }
//
//    public static List<Integer> findAllMaxSumDigits(int k) {
//        if (k > 45) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> results = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        dfs(results, stack, k, 9);
//
//        return results;
//    }
//
//    private static void dfs(List<Integer> results, Stack<Integer> stack, int remainingSum, int currentDigit) {
//        if (remainingSum == 0) {
//            results.add(stackToNumber(stack));
//            return;
//        }
//
//        for (int i = currentDigit; i >= 1; i--) {
//            if (remainingSum >= i) {
//                stack.push(i);
//                dfs(results, stack, remainingSum - i, i - 1);
//                stack.pop();
//            }
//        }
//    }
//
//    private static int stackToNumber(Stack<Integer> stack) {
//        int result = 0;
//        for (int digit : stack) {
//            result = result * 10 + digit;
//        }
//        // Thêm số 0 ở cuối
//        result = result * 10;
//        return result;
//    }

    public static long max(int k) {
        if (k < 0 || k > 45) {
            return -1;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            if (k - i >= 0) {
                builder.insert(0, i);
                k -= i;
            }
        }

        System.out.println("builder = " + builder.toString());

        for (int i = 0; i < builder.length(); i++) {
            if (k > 0) {
                int valueAt = Character.getNumericValue(builder.charAt(i));
                int leftToAdd = Math.min(k, 9 - (i + valueAt));
                builder.setCharAt(i, Character.forDigit(valueAt + leftToAdd, 10));
                System.out.println("process = " + builder.toString());
                k -= leftToAdd;
            }
        }
        return builder.length() == 0 ? 0 : Long.parseLong(builder.toString()) * 10;
    }

    @Test
    public void testMax() {
        assertEquals(8543210, max(23));
        assertEquals(953210, max(20));
        assertEquals(98743210, max(34));
        assertEquals(0, max(0));
        assertEquals(10, max(1));
        assertEquals(9876543210L, max(45));
        assertEquals(-1, max(-1));
        assertEquals(-1, max(46));
    }

}
