package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/broken-calculator/

    Cho 2 số nguyên a và b, ở mỗi bước ta có thể thực một trong hai phép toán sau:

        (1) Nhân đôi a (a -> 2*a)

        (2) Giảm a (a -> a - 1)

    Trả về số bước nhỏ nhất để biến a -> b thông qua các phép toán trên.
 */
public class BrokenCalculator {

    public int brokenCalc(int startValue, int target) {
        // Nếu startValue >= target, ta chỉ cần lần lượt trừ 1 để biến startValue thành target.
        // Số lượng phép toán cần thiết trong trường hợp này là startValue - target.
        if (startValue >= target) return startValue - target;

        // Nếu target là số chẵn, ta có thể tận dụng phép chia đôi để giảm kích thước của target
        // nhanh hơn thay vì thực hiện phép trừ. Chia target cho 2 và tính lại số bước từ
        // startValue đến target / 2, mỗi bươc chia đôi là một bước.
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }

        return 1 + brokenCalc(startValue, target + 1);
    }

    public int brokenCalc_OK(int startValue, int target) {
        int step = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
            step++;
        }
        return step + (startValue - target);
    }

    @Test
    public void test() {
        // @formatter:off
        assertEquals(2, brokenCalc(2, 3));  // 2 -> 4 -> 3
        assertEquals(2, brokenCalc(5, 8));  // 5 -> 4 -> 8
        assertEquals(3, brokenCalc(3, 10)); // 3 -> 6 -> 5 -> 10
        // @formatter:on
    }

}
