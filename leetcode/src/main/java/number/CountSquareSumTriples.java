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
        int maxSquare = 2 * n * n;
        boolean[] isPerfect = new boolean[maxSquare + 1];
        int limit = (int) Math.sqrt(maxSquare);

        // Precompute perfect squares
        for (int x = 1; x <= limit; x++) {
            isPerfect[x * x] = true;
        }

        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int cSquare = a * a + b * b;
                // Check if c^2 is perfect and c <= n (i.e., c^2 <= n^2)
                if (cSquare <= n * n && isPerfect[cSquare]) {
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
