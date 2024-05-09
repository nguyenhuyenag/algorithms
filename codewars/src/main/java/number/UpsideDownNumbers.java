package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Upside down number là xoay 1 số 180 độ (chiều kim đồng hồ) không đổi, ví dụ
 *
 * Quy tắc: [0 -> 0, 1 -> 1, 6 -> 9, 8 -> 8, 9 -> 6], còn các số khác không xoay được
 *
 * 101		->		101		->		upside number
 * 88		->		88		->		upside number
 *
 * Đếm số upside down trong khoảng [m, n]
 */
public class UpsideDownNumbers {

//    public boolean isUpsideDownNumber(int num) {
//        String numStr = String.valueOf(num);
//        String nem = numStr.replaceAll("[01689]", "");
//        if (nem.length() > 0) {
//            return false;
//        }
//        String str = new StringBuilder(numStr).reverse().toString();
//        str = str.replaceAll("6", "t") //
//                .replaceAll("9", "6") //
//                .replaceAll("t", "9");
//        return numStr.equals(str);
//    }

    public char rotate(char ch) {
        return switch (ch) {
            case '6' -> '9';
            case '9' -> '6';
            default -> ch;
        };
    }

    public boolean isUpsideDownNumber(int n) {
        String numStr = String.valueOf(n);
        // UpsideDownNumber là số chỉ chứa 0,1,6,8,9
        if (!numStr.matches("[01689]+")) {
            return false;
        }
        StringBuilder builder = new StringBuilder(numStr);
        for (int i = 0; i < builder.length(); i++) {
            builder.setCharAt(i, rotate(builder.charAt(i)));
        }
        return n == Integer.parseInt(builder.reverse().toString());
    }

    public int solve(int m, int n) {
        int count = 0;
        for (int i = m; i < n; i++) {
            if (isUpsideDownNumber(i)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void basicTests() {
        assertEquals(3, solve(0, 10));
        assertEquals(4, solve(10, 100));
        assertEquals(12, solve(100, 1000));
        assertEquals(20, solve(1000, 10000));
        assertEquals(6, solve(10000, 15000));
        assertEquals(9, solve(15000, 20000));
        assertEquals(15, solve(60000, 70000));
        assertEquals(55, solve(60000, 130000));
    }

}
