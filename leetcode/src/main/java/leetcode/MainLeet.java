package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // Tìm số lượng bit chung bên trái của left và right
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Dịch trái left để lấy kết quả cuối cùng
        return left << shift;
    }

    @Test
    public void test() {
        assertEquals(2147483647, rangeBitwiseAnd(2147483647, 2147483647));
    }

}
