package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a9c35e9ba1bb5c54a0001ac/
 *
 * Công 2 số
 *
 * Xem thêm: SumStringsAsNumbers.java
 */
public class SumOfTwoIntegers {

    public static String leftPad(String str, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - str.length());
        return "0".repeat(numZeros) + str;
    }

    public static int[] convertStringToArray(String numStr) {
        return numStr.chars().map(Character::getNumericValue).toArray();
    }

    /**
     * Trừ hai số a - b với a > b
     */
    public static String subtract(int x, int y) {
        String strX = Integer.toString(x);
        String strY = Integer.toString(y);

        int maxLen = Math.max(strX.length(), strY.length());

        int[] A = convertStringToArray(leftPad(strX, maxLen));
        int[] B = convertStringToArray(leftPad(strY, maxLen));

        System.out.println("arr1 = " + Arrays.toString(A));
        System.out.println("arr2 = " + Arrays.toString(B));

        int borrow = 0; // Số mượn
        StringBuilder ans = new StringBuilder();

        for (int i = maxLen - 1; i >= 0; i--) {
            int sub;
            A[i] -= borrow; // Nếu bước trước đó có mượn thì trừ đi
            if (A[i] >= B[i]) {
                borrow = 0;
                sub = A[i] - B[i];
            } else {
                borrow = 1;
                sub = 10 + A[i] - B[i];
            }
            ans.append(sub);
        }
        String result = ans.reverse().toString();
        // Xóa bỏ số 0 vô nghĩa
        result = result.replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    public static String addtract(int x, int y) {
        String strX = Integer.toString(x);
        String strY = Integer.toString(y);

        int maxLen = Math.max(strX.length(), strY.length());

        int[] A = convertStringToArray(leftPad(strX, maxLen));
        int[] B = convertStringToArray(leftPad(strY, maxLen));

        // System.out.println("arr1 = " + Arrays.toString(A));
        // System.out.println("arr2 = " + Arrays.toString(B));

        int carry = 0; // Số nhớ
        StringBuilder ans = new StringBuilder();

        for (int i = maxLen - 1; i >= 0; i--) {
            int sum;
            A[i] += carry; // Nếu bước trước đó có nhớ thì cộng thêm
            if (A[i] + B[i] <= 9) {
                carry = 0;
                sum = A[i] + B[i];
            } else {
                carry = 1;
                sum = (A[i] + B[i]) % 10;
            }
            ans.append(sum);
        }

        // Nếu ở cuối vòng lặp mà vẫn còn nhớ
        if (carry > 0) {
            ans.append(carry);
        }

        String result = ans.reverse().toString();
        // Xóa bỏ số 0 vô nghĩa
        result = result.replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    public static int add(int x, int y) {
        String ans;
        if (x >= 0 && y >= 0) {
            ans = addtract(x, y);
        } else if (x < 0 && y < 0) {
            ans = "-" + addtract(-x, -y);
        } else {
            // Một số là số âm và một số không âm
            if (x > 0) { // y < 0
                if (Math.abs(x) < Math.abs(y))
                    ans = "-" + subtract(x, -y);
                else
                    ans = subtract(x, -y);
            } else { // x < 0, y > 0
                if (Math.abs(x) < Math.abs(y))
                    ans = subtract(-x, y);
                else
                    ans =  "-" + subtract(-x, y);
            }
        }
        return Integer.parseInt(ans);
    }

    @Test
    public void checkPositiveValues() {
        assertEquals(3, add(1, 2));
        assertEquals(24, add(5, 19));
        assertEquals(40, add(23, 17));
    }

    @Test
    public void checkNegativeValues() {
        assertEquals(-30, add(-14, -16));
        assertEquals(-226, add(-50, -176));
        assertEquals(-39, add(-10, -29));
    }

    @Test
    public void checkMixtureValues() {
        assertEquals(0, add(-13, 13));
        assertEquals(-9, add(-27, 18));
        assertEquals(-60, add(-90, 30));
    }

}
