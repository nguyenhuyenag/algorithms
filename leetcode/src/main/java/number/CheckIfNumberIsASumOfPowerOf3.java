package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

    Cho số nguyên dương n. Kiểm tra xem n có phải dạng

        n = 3^0 + 3^1 + ... +
 */
public class CheckIfNumberIsASumOfPowerOf3 {

    // Một số chia 3 sẽ dư 0, 1, 2
    public boolean checkPowersOfThree_OK(int n) {
        // 1 = 3^0
        if (n == 1) return true;
        // Chắc chắc là false
        if (n % 3 == 2) return false;
        // Đệ quy
        return checkPowersOfThree_OK(n / 3);
    }

    public boolean checkPowersOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

//    // Một số chia 3 sẽ dư 2, 1, 0
//    public boolean checkPowersOfThree(int n) {
//        List<Integer> pow3s = new ArrayList<>();
//        for (int i = 0; (int) Math.pow(3, i) <= n; i++) {
//            pow3s.add((int) Math.pow(3, i));
//        }
//        return go(pow3s, 0, n);
//    }
//
//    public boolean go(List<Integer> pt, int idx, int n) {
//        if (idx == pt.size()) {
//            return n == 0;
//        }
//        return go(pt, idx + 1, n) || go(pt, idx + 1, n - pt.get(idx));
//    }

    @Test
    public void test() {
        // assertEquals(true, checkPowersOfThree(3));
        // assertEquals(true, checkPowersOfThree(9));
        // assertEquals(true, checkPowersOfThree(12));
        assertEquals(true, checkPowersOfThree(91));
    }

}
