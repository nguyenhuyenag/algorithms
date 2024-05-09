package array;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/
 *
 * Cho mảng số nguyên, mảng con tạo thành 1 dãy liên tục thì ghép thành "fist-last"
 *
 * Ví dụ: [-3, -2, -1, 2, 10, 15, 16, 18, 19, 20] -> "-3--1,2,10,15,16,18-20"
 */
public class RangeExtraction {

    private static void createRange(LinkedList<Integer> list, StringJoiner result) {
        int size = list.size();
        if (size == 1) {
            result.add(list.getFirst().toString());
        } else if (size == 2) {
            result.add(list.getFirst() + "," + list.getLast());
        } else {
            result.add(list.getFirst() + "-" + list.getLast());
        }
        list.clear();
    }

    public static String rangeExtraction(int[] arr) {
        StringJoiner result = new StringJoiner(",");
        LinkedList<Integer> list = new LinkedList<>();
        for (int x : arr) {
            // Nếu số thêm mới không phải là số liền kề ở đình -> Ghép thành chuỗi
            if (!list.isEmpty() && x != list.getLast() + 1) {
                createRange(list, result);
            }
            list.add(x);
        }
        // Nếu list vẫn còn phần tử -> Ghép chuỗi
        createRange(list, result);
        return result.toString();
    }

    @Test
    public void test_BasicTests() {
        assertEquals("-3--1,2,10,15,16,18-20", rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        assertEquals("-10--8,-6,-3-1,3-5,7-11,14,15,17-20", rangeExtraction(new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
    }

}
