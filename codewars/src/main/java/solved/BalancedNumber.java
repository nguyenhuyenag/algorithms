package solved;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a4e3782880385ba68000018/
 */
public class BalancedNumber {

    public static String balancedNum(long number) {
        String strNum = String.valueOf(number);
        char[] arr = strNum.toCharArray();
        // System.out.println("arr = " + Arrays.toString(arr));

        int len = arr.length;
        int mid = arr.length / 2;

        arr[mid] = 0;
        if (len % 2 == 0) {
            arr[mid - 1] = 0;
        }

        int l = 0, r = len - 1;
        int leftSum = 0, rightSum = 0;

        while (l < r) {
            leftSum += Character.getNumericValue(arr[l]);
            rightSum += Character.getNumericValue(arr[r]);
            // System.out.println(arr[l] + ", " + arr[r]);
            l++;
            r--;
        }

        // System.out.println("leftSum = " + leftSum + ", rightSum = " + rightSum);

        return leftSum == rightSum ? "Balanced" : "Not Balanced";
    }

    @Test
    public void doTest() {
        // balancedNum(424);
        assertEquals("Balanced", balancedNum(7));
        assertEquals("Balanced", balancedNum(959));
        assertEquals("Balanced", balancedNum(13));
        assertEquals("Not Balanced", balancedNum(432));
        assertEquals("Balanced", balancedNum(424));
    }

}
