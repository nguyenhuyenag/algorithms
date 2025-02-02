package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/complex-number-multiplication/

    Nhân 2 số phức:

        (a + bi)(x + yi) = ax-by + (ay+bx)i
 */
public class ComplexNumberMultiplication {

    public int[] extractRealAndImaginary(String complex) {
        // Remove the trailing 'i'
        String complexWithoutI = complex.replace("i", "");
        int real, imaginary;

        // Find the indices of '+' or '-' that are not at the beginning of the string
        int plusIndex = complexWithoutI.indexOf('+', 1);
        int minusIndex = complexWithoutI.indexOf('-', 1);

        if (plusIndex != -1) {
            String[] parts = complexWithoutI.split("\\+");
            real = Integer.parseInt(parts[0]);
            imaginary = Integer.parseInt(parts[1]);
        } else if (minusIndex != -1) {
            String[] parts = complexWithoutI.split("-");
            real = Integer.parseInt(parts[0]);
            imaginary = Integer.parseInt(parts[1]);
            // Adjust for the split not keeping the minus sign
            imaginary = -imaginary;
        } else {
            throw new IllegalArgumentException("Invalid complex number format");
        }

        return new int[]{real, imaginary};
    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] c1 = extractRealAndImaginary(num1);
        int[] c2 = extractRealAndImaginary(num2);
        int a = c1[0], b = c1[1];
        int x = c2[0], y = c2[1];
        int real = a * x - b * y;
        int imaginary = a * y + b * x;
        return String.format("%d+%di", real, imaginary);
    }

    public String complexNumberMultiply_OK(String num1, String num2) {
        String[] c1 = num1.split("[+i]");
        String[] c2 = num2.split("\\+|i");
        int a = Integer.parseInt(c1[0]), b = Integer.parseInt(c1[1]);
        int x = Integer.parseInt(c2[0]), y = Integer.parseInt(c2[1]);
        int real = a * x - b * y;
        int imaginary = a * y + b * x;
        return String.format("%d+%di", real, imaginary);
    }

    @Test
    public void test() {
        assertEquals("0+2i", complexNumberMultiply("1+1i", "1+1i"));
        assertEquals("0+-2i", complexNumberMultiply("1+-1i", "1+-1i"));
    }

}
