package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class NumbersWithSameConsecutiveDifferences {

//    public int[] numsSameConsecDiff(int n, int k) {
//        Set<Integer> result = new HashSet<>();
//        for (int i = 1; i <= 9; i++) {
//            int last = i;
//            StringBuilder num = new StringBuilder(String.valueOf(i));
//            while (num.length() < n) {
//                if (last + k <= 9) {
//                    last = last + k;
//                    num.append(last);
//                } else if (last - k >= 0) {
//                    last = last - k;
//                    num.append(last);
//                } else {
//                    break;  // If neither condition is met, stop constructing this number
//                }
//            }
//            // Only add the number if it has exactly `n` digits
//            if (num.length() == n) {
//                result.add(Integer.parseInt(num.toString()));
//            }
//        }
//        return result.stream().mapToInt(t -> t).toArray();
//    }

    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<>();

        for (int i = 1; i <= 9; i++) {  // Start from digits 1 to 9 (no leading zeros)
            int last = i;
            StringBuilder num = new StringBuilder(String.valueOf(i));

            while (num.length() < n) {
                boolean added = false;

                // Try adding k to the last digit
                if (last + k <= 9) {
                    last = last + k;
                    num.append(last);
                    added = true;  // Mark that a valid digit was appended
                }

                // Try subtracting k from the last digit (if k > 0 to avoid duplicates)
                if (!added && last - k >= 0) {  // Check only if no valid addition
                    last = last - k;
                    num.append(last);
                    added = true;  // Mark that a valid digit was appended
                }

                // If no valid addition or subtraction was made, exit the loop
                if (!added) {
                    break;
                }
            }

            // Only add the number if its length matches `n`
            if (num.length() == n) {
                result.add(Integer.parseInt(num.toString()));
            }
        }

        // Convert the result set to an array
        return result.stream().mapToInt(t -> t).toArray();
    }


    @Test
    public void test() {
        // sortAndTest(new int[]{181, 292, 707, 818, 929}, numsSameConsecDiff(3, 7));
        sortAndTest(new int[]{10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98}, numsSameConsecDiff(2, 1));
    }

    public void sortAndTest(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

}
