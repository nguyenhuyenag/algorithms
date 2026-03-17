package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
	https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/

	Cho một số nguyên num, hãy trả về ba số nguyên liên tiếp (dưới dạng mảng đã sắp xếp) sao cho
	tổng của chúng bằng num.

	Nếu không thể biểu diễn num thành tổng của ba số nguyên liên tiếp, hãy trả về một mảng rỗng.

	Ý tưởng:

		Vì: n + (n + 1) + (n + 2) = num -> 3n + 3 = num -> n = num / 3 - 1

		=> Tức là num phải chia hết cho 3.
*/
public class FindThreeConsecutiveIntegersThatSumToAGivenNumber {

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) return new long[]{};
        long n = num / 3 - 1;
        return new long[]{n, n + 1, n + 2};
    }

    @Test
    public void test() {
        assertArrayEquals(new long[]{}, sumOfThree(4));
        assertArrayEquals(new long[]{10, 11, 12}, sumOfThree(33));
        assertArrayEquals(new long[]{}, sumOfThree(455172614));
    }

}
