package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/three-consecutive-odds/

    Kiểm tra xem mảng có 3 số nguyên lẽ liên tiếp hay không?
 */
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(false, threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        assertEquals(true, threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

}
