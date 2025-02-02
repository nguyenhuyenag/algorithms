package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/three-consecutive-odds/

    Kiểm tra xem mảng có 3 số nguyên lẽ liên tiếp hay không?
 */
public class ThreeConsecutiveOdds {

    /*
        Sẽ có số kiểm tra 3 lần
     */
    public boolean threeConsecutiveOdds_1(int[] arr) {
        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean threeConsecutiveOdds_2(int[] nums) {
        StringBuilder binary = new StringBuilder();
        for (int num : nums) {
            binary.append(num % 2);
        }
        return binary.toString().contains("111");
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 2; // Bắt đầu từ vị trí thứ 3 (index = 2)
        while (i < arr.length) {
            // Nếu vị trí i chẵn thì nhảy bước i + 3
            if (arr[i] % 2 == 0) {
                i += 3;
                continue;
            }
            if (arr[i - 1] % 2 == 0) {
                i += 2;
                continue;
            }
            if (arr[i - 2] % 2 == 0) {
                i += 1;
                continue;
            }
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(false, threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        assertEquals(true, threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

}
