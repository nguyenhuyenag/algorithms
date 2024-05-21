package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * <p>
 * Cho hai số nguyên a, b. Trả về a/b dạng chuỗi của số thập phân
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int a, int b) {
        StringBuilder result = new StringBuilder();

        // Xác định dấu
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            result.append("-");
        }

        long num = Math.abs(a);
        long den = Math.abs(b);

        long quotient = num / den; // Phần nguyên
        long remainder = num % den; // Phần dư

        result.append(quotient);

        // Chia a chia hết cho b -> dừng
        if (remainder == 0)
            return result.toString();

        // Không chia hết
        result.append(".");

        Map<Long, Integer> map = new HashMap<>();

        // Theo dõi số dư
        while (remainder > 0) {
            System.out.println("map = " + map);
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                result.insert(pos, "(");
                result.append(")");
                return result.toString();
            } else {
                map.put(remainder, result.length());
                remainder *= 10;
                quotient = remainder / den;
                remainder %= den;
                result.append(quotient);
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        // assertEquals("5", fractionToDecimal(10, 2));
        // assertEquals("3.(3)", fractionToDecimal(10, 3));
        assertEquals("0.(012)", fractionToDecimal(4, 333));
        // assertEquals("0.(09)", fractionToDecimal(1, 11));
        // assertEquals("0.(1112)", fractionToDecimal(1112, 9999));
    }

}
