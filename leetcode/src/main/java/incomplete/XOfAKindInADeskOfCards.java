package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

    Cho mảng số nguyên, kiểm tra xem mảng có thể chia thành n/2 cặp dạng [a[i], a[i]]
 */
public class XOfAKindInADeskOfCards {

    private int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : deck) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
            // counter.merge()
        }
        int gcd = -1;
        for (int count : counter.values()) {
            if (gcd == -1) {
                gcd = count;
            } else {
                gcd = findGCD(gcd, count);
                if (gcd == 1) {
                    return false; // Early exit if GCD becomes 1
                }
            }
        }
        return gcd >= 2;
    }

    @Test
    public void test() {
        assertEquals(true, hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        assertEquals(false, hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

}
