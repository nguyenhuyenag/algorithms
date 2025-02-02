package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/sequential-digits/description/
 *
 * Sequential digits là số mà chữ số phía sau lớn hơn số phía trước đúng 1 đơn vị.
 *
 * Tìm tất cả các số sequential digits trong đoạn [m, n]
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits_0(int low, int high) {
        List<Integer> result = new ArrayList<>();
        // Bắt đầu từ 1
        for (int start = 1; start < 9; start++) {
            // Tạo số mới bằng cách ghép số. Ví dụ '1'
            int num = start;
            int next = start + 1; // thì next = '2'
            while (next < 10) { // là chữ số nên chỉ thuộc [0, 9]
                num = num * 10 + next++; // Tạo ra số '12'
                if (num > high) break; // Nếu số tạo ra vượt quá chặn trên thì thoát
                if (num >= low) {
                    result.add(num); // Thỏa điều kiện thuộc [low, hight]
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        String c = "123456789";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    list.add(curr);
                }
            }
        }
        list.sort(null);
        return list;
    }

    @Test
    public void test() throws InterruptedException {
        assertIterableEquals(List.of(123, 234), sequentialDigits(100, 300));
        assertIterableEquals(List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345), sequentialDigits(1000, 13000));
    }

}
