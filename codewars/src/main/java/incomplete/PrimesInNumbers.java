package incomplete;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*-
    https://www.codewars.com/kata/54d512e62a5e54c96200019e/

    Phân tích một số nguyên dương n thành các thừa số nguyên tố: (p1**k1)(p2**k2)...(pn**kn)
 */
public class PrimesInNumbers {

    public static String factors_1(int n) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> primeFactors = new LinkedHashMap<>();
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            primeFactors.put(n, primeFactors.getOrDefault(n, 0) + 1);
        }
        primeFactors.forEach((prime, count) -> {
            if (count > 1) {
                result.append("(").append(prime).append("**").append(count).append(")");
            } else {
                result.append("(").append(prime).append(")");
            }
        });
        return result.toString();
    }

//    public static String factors(int n) {
//        StringBuilder result = new StringBuilder();
//        for (int i = 2; i * i <= n; i++) {
//            int count = 0;  // Start count at 0
//            while (n % i == 0) {
//                count++;
//                n /= i;
//            }
//            if (count > 0) {
//                result.append("(").append(i);
//                if (count > 1) {
//                    result.append("**").append(count);
//                }
//                result.append(")");
//            }
//        }
//        if (n > 1) {
//            result.append("(").append(n).append(")");
//        }
//        return result.toString();
//    }

    public static String factors(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i * i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                result.append(String.format(count > 1 ? "(%d**%d)" : "(%d)", i, count));
            }
        }
        if (n > 1) result.append(String.format("(%d)", n));
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("(2**5)(5)(7**2)(11)", factors(86240));
        assertEquals("(3**2)", factors(9));
    }

}
