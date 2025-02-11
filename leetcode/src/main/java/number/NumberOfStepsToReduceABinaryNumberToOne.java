package number;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

    Cho số nguyên dạng nhị phân:

        - Nếu là số chẵn thì chia cho 2.

        - Nếu là số lẽ thì cộng 1.

    Trả về số bước khi kết quả là 1.
 */
public class NumberOfStepsToReduceABinaryNumberToOne {

    public boolean isEven(String binary) {
        return binary.charAt(binary.length() - 1) == '0';
    }

    public String addOne(String binary) {
        BigInteger number = new BigInteger(binary, 2);
        number = number.add(BigInteger.ONE);
        return number.toString(2);
    }

    public int numSteps(String binary) {
        int count = 0;
        while (!"1".equals(binary)) {
            binary = isEven(binary) ? binary.substring(0, binary.length() - 1) : addOne(binary);
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(6, numSteps("1101"));
        assertEquals(1, numSteps("10"));
    }

}
