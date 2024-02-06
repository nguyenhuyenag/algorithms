package codewars.number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/5583090cbe83f4fd8c000051/
 *
 * Đảo chuỗi và chuyển thành mảng
 */
public class ConvertNumberToReversedArrayOfDigits {

    public static int[] digitize0(long n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
        } else {
            while (n > 0) {
                long l = n % 10;
                result.add((int) l);
                n /= 10;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] digitize(long n) {
        return new StringBuilder()
                .append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 3, 2, 5, 3}, digitize(35231));
        assertArrayEquals(new int[]{0}, digitize(0));
    }

}
