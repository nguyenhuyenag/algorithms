package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

    Cho số nguyên dương n. Kiểm tra xem n có phải dạng

        n = 3^0 + 3^1 + ... +
 */
public class CheckIfNumberIsASumOfPowerOf3 {

    // Một số chia 3 sẽ dư 2, 1, 0
    public boolean checkPowersOfThree(int n) {
        // 1 = 3^0
        if (n == 1) return true;

        // Chắc chắc là false
        if (n % 3 == 2) return false;

        return checkPowersOfThree(n / 3);
    }

    @Test
    public void test() {
        // assertEquals(true, checkPowersOfThree(3));
        assertEquals(true, checkPowersOfThree(9));
        assertEquals(true, checkPowersOfThree(12));
        assertEquals(true, checkPowersOfThree(91));
    }

}
