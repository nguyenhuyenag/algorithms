package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
    A square triple (a,b,c) is a triple where a, b, and c are integers and a^2 + b^2 = c^2.
    Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

    Ý tưởng:

    - Việc dùng Math.sqrt trong vòng lặp n × n là rất chậm. Để nhanh hơn, ta cần loại bỏ sqrt
    và chuyển nó thành kiểm tra O(1).

    - Ta có đánh giá: c^2 = a^2 + b^2 <= n^2 + n^2 = 2n^2  => c ≤ sqrt(2)n.

    - Vậy ta có thể tạo một mảng:

        isPerfect[x] = true nếu x là số chính phương

    => Duyệt i từ 1 đến sqrt(2n²)

        + Đánh dấu isPerfect[i*i] = true

        + Giờ ta có thể kiểm tra một số có phải là bình phương hay không chỉ
        bằng isPerfect[cSquare] → O(1), không cần sqrt.

    Xem thêm: SumOfSquareNumbers
 */
public class CountSquareSumTriples {

    public int countTriples_OK(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int cSquare = a * a + b * b;
                int c = (int) Math.sqrt(cSquare);
                if (c * c == cSquare && c <= n) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countTriples(int n) {
        int maxC2 = 2 * n * n; // Max c^2 = a^2 + b^2 <= n^2 + n^2 = 2n^2
        boolean[] isPerfect = new boolean[maxC2 + 1];
        int limit = (int) Math.sqrt(maxC2);
        for (int c = 1; c <= limit; c++) {
            isPerfect[c * c] = true;
        }

        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;
                if (c2 <= n * n && isPerfect[c2]) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countTriples(5));
        assertEquals(4, countTriples(10));
    }

}
