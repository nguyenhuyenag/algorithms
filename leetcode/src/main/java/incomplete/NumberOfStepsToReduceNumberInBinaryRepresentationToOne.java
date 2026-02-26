package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

    Cho một số dưới dạng nhị phân. Tìm số bước cần thiết để giảm số đó về 1 (thập phân) theo
    các quy tắc sau:

        - Nếu số hiện tại là số chẵn, bạn phải chia nó cho 2.

        - Nếu số hiện tại là số lẻ, bạn phải cộng thêm 1 vào nó.

    Đảm bảo rằng với mọi trường hợp kiểm thử, bạn luôn có thể đưa số đó về 1.

    ** Quy tắc cộng 1 vào binary:

        Đi từ phải sang trái:
            - Gặp 1 → đổi thành 0, tiếp tục carry (nhớ 1).
            - Gặp 0 → đổi thành 1, dừng.
            - Nếu hết mà vẫn carry → thêm 1 vào đầu.
 */
public class NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

    private void addOne(StringBuilder binary) {
        int lastIndex = binary.length() - 1;

        // xử lý carry
        while (lastIndex >= 0 && binary.charAt(lastIndex) == '1') {
            binary.setCharAt(lastIndex, '0');
            lastIndex--;
        }

        if (lastIndex >= 0) {
            binary.setCharAt(lastIndex, '1');
        } else {
            // toàn là 1 -> thêm 1 ở đầu
            binary.insert(0, '1');
        }
    }

    public int numSteps(String s) {
        int count = 0;
        StringBuilder builder = new StringBuilder(s);

        while (builder.length() > 1) {
            int lastIndex = builder.length() - 1;
            if (builder.charAt(lastIndex) == '0') {
                // Số chẵn -> chia 2 (bỏ bit cuối)
                builder.deleteCharAt(lastIndex);
            } else {
                // Số lẻ -> cộng 1
                int i = lastIndex;

                // xử lý carry
                while (i >= 0 && builder.charAt(i) == '1') {
                    builder.setCharAt(i, '0');
                    i--;
                }

                if (i >= 0) {
                    builder.setCharAt(i, '1');
                } else {
                    // toàn là 1 (vd: 111 -> 1000)
                    builder.insert(0, '1');
                }
            }
            count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(6, numSteps("1101"));
    }

    @Test
    public void test2() {
        assertEquals(1, numSteps("10"));
    }

}
