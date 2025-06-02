package hastable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://www.codewars.com/kata/54da539698b8a2ad76000228/

    Bạn đến sớm buổi tiệc 10p và quyết định nên quyết định đi dạo xung quanh. Cho mảng ['n', 's', 'w', 'e'] đại biểu các hướng sẽ đi. Mỗi hướng sẽ cần 1p để đi hết. Viết hàm kiểm tra để đảm rằng liệu mảng đã cho có đủ thời gian để đi dạo 10p hay không. Nếu có thì trả về True, nếu không thì trả về False.

    Giải thích:
        Độ dài khác 10 → false.
        Tổng dịch chuyển theo trục Bắc-Nam (n - s) và Đông-Tây (e - w) phải bằng 0.
 */
public class TakeATenMinutesWalk {

    public static boolean isValid_1(char[] walk) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char direction : walk) {
            counter.put(direction, counter.getOrDefault(direction, 0) + 1);
        }
        return walk.length == 10 &&
                counter.getOrDefault('n', 0).equals(counter.getOrDefault('s', 0)) &&
                counter.getOrDefault('e', 0).equals(counter.getOrDefault('w', 0));
    }

    public static boolean isValid(char[] walk) {
        int nsCount = 0, ewCount = 0;
        for (char direction : walk) {
            switch (direction) {
                case 'n':
                    nsCount++;
                    break;
                case 's':
                    nsCount--;
                    break;
                case 'e':
                    ewCount++;
                    break;
                case 'w':
                    ewCount--;
                    break;
            }
        }
        return walk.length == 10 && nsCount == 0 && ewCount == 0;
    }

    private static void doTest(char[] input, boolean expected) {
        String message = "for input = " + Arrays.toString(input);
        boolean actual = isValid(input);
        assertEquals(expected, actual, message);
    }

    @Test
    void falseWalkTooShort() {
        doTest(new char[]{'n'}, false);
        doTest(new char[]{'n', 's'}, false);
    }

    @Test
    void falseWalkTooLong() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
    }

    @Test
    void falseDoesNotLoopBackToStart() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n'}, false);
        doTest(new char[]{'e', 'e', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'}, false);
        doTest(new char[]{'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w'}, false);
        doTest(new char[]{'s', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e'}, false);
        doTest(new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'}, false);
    }

    @Test
    void trueIsValid10MinutesWalk() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, true);
        doTest(new char[]{'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, true);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'}, true);
    }

}
