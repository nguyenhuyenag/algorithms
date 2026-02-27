package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

    Cho số nguyên dương n. Ta có thể hoán đổi vị trí 2 chữ số nếu chúng có cùng
    tính chẵn - lẻ

    Hãy trả về giá trị lớn nhất.

    Ý tưởng:

        - Giữ nguyên cấu trúc chẵn - lẽ của số ban đầu.
        - Chia các chữ số ra 2 dãy chẵn và lẽ, sắp xếp chúng theo thứ tự giảm dần.
        - Duyệt số ban đầu, tùy thuộc vào tính chẵn lẽ mà lấy các phần tử của 2 dãy
          ghép vào lần lượt.
 */
public class LargestNumberAfterDigitSwapsByParity {

    public int largestInteger1(int num) {
        String s = String.valueOf(num);
        boolean[] marked = new boolean[s.length()];
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            boolean isEven = digit % 2 == 0;
            if (isEven) {
                even.add(digit);
            } else {
                odd.add(digit);
            }
            marked[i] = isEven;
        }
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());
        int result = 0;
        int pe = 0, po = 0;
        for (boolean b : marked) {
            if (b) {
                result = 10 * result + even.get(pe++);
            } else {
                result = 10 * result + odd.get(po++);
            }
        }
        return result;
    }

    public int largestInteger2(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Tách chẵn và lẻ
        for (char c : digits) {
            int d = c - '0';
            if ((d & 1) == 0) {
                even.add(d);
            } else {
                odd.add(d);
            }
        }
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());
        int result = 0;
        int pe = 0, po = 0; // Hai con trỏ
        for (char d : digits) {
            result = result * 10 + ((d & 1) == 0 ? even.get(pe++) : odd.get(po++));
        }
        return result;
    }

    public int largestInteger(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        // Dùng 2 hàng đợi
        Queue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        // Tách chẵn và lẻ
        for (char c : digits) {
            int d = c - '0';
            if ((d & 1) == 0) {
                even.add(d);
            } else {
                odd.add(d);
            }
        }

        int result = 0;
        for (char d : digits) {
            result = result * 10 + ((d & 1) == 0 ? even.poll() : odd.poll());
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(3412, largestInteger(1234));
    }

    @Test
    public void test2() {
        assertEquals(87655, largestInteger(65875));
    }

}
