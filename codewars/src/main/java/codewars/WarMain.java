package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/514b92a657cdc65150000006/
 *
 * Liệt kê tất cả các số tự nhiên < 10 là bội số của 3 hoặc 5, chúng ta sẽ thu được 3, 5, 6 và 9. Tổng của những bội số này là 23.
 *
 * Giải bài toán trong trường hợp n
 *
 * Chú ý: Nếu số đó là bội số của cả 3 và 5, chỉ tính một lần, ví dụ số 15
 */
public class WarMain {

    public int solution(int number) {
        int sum = 0;
        boolean[] mark = new boolean[number + 1];
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    @Test
    public void doTest() {
        assertEquals(23, solution(10));
    }

}
