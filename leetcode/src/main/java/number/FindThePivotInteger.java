package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/find-the-pivot-integer/

    Số pivot là số chia đoạn [1,n] thành 2 đoạn sao cho sum([1,x]) = sum([x,n])

    Cho số n, tìm số pivot. Nếu không có thì trả về -1.
 */
public class FindThePivotInteger {

    /**
     * Trick ở đây là x thường nằm cuối nên duyệt từ cuối về sẽ nhanh hơn đáng kể.
     */
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int leftSum = 0;
        for (int i = n; i >= 1; i--) {
            leftSum += i;
            int rightSum = sum - leftSum + i;
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(6, pivotInteger(8));
        assertEquals(-1, pivotInteger(4));
    }

//        public int pivotInteger(int n) {
//        int sum = n * (n + 1) / 2;
//        int leftSum = 0;
//        for (int i = 1; i <= n; i++) {
//            leftSum += i;
//            int rightSum = sum - leftSum + i;
//            if (leftSum == rightSum) return i;
//            if (leftSum > rightSum) break;
//        }
//        return -1;
//    }
//
}
