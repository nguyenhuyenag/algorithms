package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/simplified-fractions/
 *
 * Cho số nguyên dương n. Tìm tất cả phân số thuộc (0, n) có mẫu số <= n.
 */
public class SimplifiedFractions {

    // a = b * x + y -> gcd(a,b) = gcd(b, a % b)
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        Set<String> result = new HashSet<>();
        for (int i = 1; i <= n - 1; i++) { // Chỉ cần chạy đến n - 1
            for (int j = i + 1; j <= n; j++) { // Chạy đến n
                // int gcd = gcd(i, j);
                if (gcd(i, j) == 1) {
                    // String f = i + "/" + j;
                    result.add(i + "/" + j);
                }
            }
        }
        return new ArrayList<>(result);
    }

    @Test
    public void test() {
        assertIterableEquals(List.of("1/2"), simplifiedFractions(2));
    }

}
