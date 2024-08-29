package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/5a6b24d4e626c59d5b000066/


 */
public class SquareSums {

    // Tìm j nhỏ nhất sao cho i + j là số chính phương
    public static int pair(int i) {
        int j = i + 1;
        while (isSquare(i + j)) {
            j++;
        }
        return j;
    }

    public static boolean isSquare(int n) {
        int b = (int) Math.sqrt(n);
        return n == b * b;
    }

    public static int[] squareSumsRow(int n) {
        int[] result = new int[n];
        Set<Integer> unique = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        if (backtrack(0, n, result, unique)) {
            return result;
        }
        return new int[0]; // Nếu không tìm thấy dãy thỏa mãn
    }

    private static boolean backtrack(int index, int n, int[] result, Set<Integer> unique) {
        if (index == n) {
            return true;
        }
        for (int num : unique) {
            if (index == 0 || isSquare(result[index - 1] + num)) {
                result[index] = num;
                Set<Integer> newUnique = new HashSet<>(unique);
                newUnique.remove(num);

                if (backtrack(index + 1, n, result, newUnique)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8}, squareSumsRow(15));
    }

}
