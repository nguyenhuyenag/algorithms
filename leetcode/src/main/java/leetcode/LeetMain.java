package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/water-bottles/
 *
 * Cho n chai nước mà số m. Sau khi uống hết, thì m chai rỗng sẽ đổi được 1 chai mới.
 * Tìm số chai nước có thể uống
 */
public class LeetMain {

    public static int numWaterBottles(int soChai, int soChaiDoi) {
        int totalDrinks = 0;

        // Initial drinks from full bottles
        totalDrinks += soChai;

        while (soChai >= soChaiDoi) {
            int soChaiMoi = soChai / soChaiDoi;         // Đổi chai mới
            totalDrinks += soChaiMoi;                   // Uống hết
            soChai = soChaiMoi + soChai % soChaiDoi;    // Remaining bottles after exchange
        }

        return totalDrinks;
    }

    @Test
    public void doTest() {
        // assertEquals(true, backspaceCompare("ab#c", "ad#c"));
        int n = 15;
        int m = 4;
        int drink = n;
        System.out.println("Đổi = " + n / m);
        System.out.println("Dư = " + n % m);
        int count = 0;
        while (count < m) {
            count++;
            System.out.println("count = " + count);
        }
    }

}
