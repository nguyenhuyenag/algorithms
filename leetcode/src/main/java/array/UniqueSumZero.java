package array;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
 	https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

 	Tạo mảng n số nguyên khác nhau có tổng  = 0.

 	=> Gán n - 1 số (>=0) đầu tiên là sum, gán số cuối cùng -sum.
 */
public class UniqueSumZero {

	public int[] sumZero(int n) {
		int sum = 0;
		int[] result = new int[n];
		for (int i = 0; i < n - 1; i++) {
			result[i] = i + 1;
			sum += result[i];
		}
		result[n - 1] = -sum;
		return result;
	}

	@Test
	public void test() {
	    assertEquals(0, Arrays.stream(sumZero(5)).sum());
	}

}
