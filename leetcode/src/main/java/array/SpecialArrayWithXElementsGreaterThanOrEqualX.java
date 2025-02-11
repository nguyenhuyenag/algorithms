package array;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

    Cho mảng số nguyên không âm. Trả về x nếu tồn tại ĐÚNG x phần tử có giá trị >= x,
    ngược lại thì trả về -1.

    Ví dụ 1: arr = [3, 5] => 2 (vì có đúng hai số 3, 5 đều lớn hơn 2).

    Ví dụ 2: arr = [0, 0] => -1, bởi vì:
        + Nếu x = 0 thì phải tồn tại 0 số >= x, nhưng tồn tại 2 số.
        + Nếu x = 1 thì phải tồn tại 1 số >= x, nhưng không tồn tại.
        + Nếu x = 2 thì phải tồn tại 2 số >= x, nhưng không tồn tại.
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public int count(int[] nums, int val) {
        return (int) Arrays.stream(nums).filter(x -> x >= val).count();
    }

    public int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            if (count(nums, i) == i) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, specialArray(new int[]{3, 5}));
        assertEquals(-1, specialArray(new int[]{0, 0}));
    }

}
