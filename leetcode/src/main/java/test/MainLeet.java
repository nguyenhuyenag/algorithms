package test;


import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    https://leetcode.com/problems/beautiful-arrangement-ii/

    Cho hai số nguyên n, k. Tạo một mảng các số nguyên dương khác nhau [a0, a1,...,an] sao cho
    [|a0 - a1|, |a1 - a2|,...,|a(n-1) - an|] chứa đúng k số nguyên khác nhau.
 */
public class MainLeet {

    public int maximumSwap(int num) {
        int max_digit = 0;
        int d = 0;
        int temp = 1, index = 1;
        int n = num;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            if (max_digit > digit) {
                d = Math.max(d, (max_digit - digit) * (temp - index));
            } else if (max_digit < digit) {
                max_digit = digit;
                index = temp;
            }
            temp = temp * 10;
        }

        return num + d;
    }

    @Test
    public void test() {

    }

}
