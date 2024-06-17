package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/*
    https://leetcode.com/problems/self-dividing-numbers/

    Gọi số n là `self-dividing number` nếu nó chia hết cho tất cả các chữ số của nó.

    Tìm self-dividing number trong đoan [x,y] cho trước.
 */
public class SelfDividingNumbers {

    public boolean isSelfDividingNumber(int n) {
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || n % digit != 0) return false;
            num /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void test() {
        var result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        assertIterableEquals(result, selfDividingNumbers(1, 22));
    }

}
