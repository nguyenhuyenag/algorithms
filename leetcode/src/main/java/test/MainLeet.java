package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;


/*
    https://leetcode.com/problems/implement-rand10-using-rand7/

    Cho hàm rand7() sinh ngẫu nhiên 1 số thuôc [1,7]. Viết hàm rand10()
    chỉ sử dụng hàm rand7().
 */
public class MainLeet {

    // 1 <= x <= 7
    public int rand7() {
        return ThreadLocalRandom.current().nextInt(1, 7 + 1);
    }

    public int rand10() {
        while (true) {
            int num = 7 * rand7(); // Generate number between 1 and 49
            if (num <= 40) { // Only use numbers between 1 and 40
                return num % 10 + 1; // Số dư n % 10 -> kết quả thuộc [0, 9]
            }
        }
    }

    @Test
    public void test() {
        int val = rand10();
        assertTrue(val >= 1 && val <= 10);
    }

}
