package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/
 */
public class FractionAdditionAndSubtraction {

    public String fractionAddition(String expression) {
        expression = expression.replace("-", "+-");
        String[] fractions = expression.split("\\+");
        int numerator = 0, denominator = 1;
        for (String fraction : fractions) {
            if (!fraction.isEmpty()) {
                String[] parts = fraction.split("/");
                int num = Integer.parseInt(parts[0]);
                int den = Integer.parseInt(parts[1]);
                numerator = numerator * den + num * denominator;
                denominator *= den;

                int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
                numerator /= gcd;
                denominator /= gcd;
            }
        }
        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Test
    public void test() {
        // assertEquals("0/1", fractionAddition("-1/2+1/2"));
        assertEquals("1/3", fractionAddition("-1/2+1/2+1/3"));
        // assertEquals("-1/6", fractionAddition("1/3-1/2"));
    }

}
