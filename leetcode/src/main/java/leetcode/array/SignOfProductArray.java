package leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/sign-of-the-product-of-an-array/
public class SignOfProductArray {

	public int arraySign2(int[] nums) {
		int result = 1;
		for (int x : nums) {
			if (x == 0) {
				return 0;
			}
			if (x > 0) {
				result *= 1;
			}
			if (x < 0) {
				result *= -1;
			}
		}
		return result;
	}

	public int arraySign(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			if (x == 0) {
				return 0;
			}
			if (x < 0) {
				map.put(-1, map.getOrDefault(-1, 0) + 1);
			}
		}
		if (map.get(-1) != null) {
			return map.get(-1) % 2 == 0 ? 1 : -1;
		}
		return 1;
	}

	@Test
	public void test() {
		assertEquals(1, arraySign(new int[] { -1, -2, -3, -4, 3, 2, 1 }));
		assertEquals(0, arraySign(new int[] { 1, 5, 0, 2, -3 }));
		assertEquals(-1, arraySign(new int[] { -1, 1, -1, 1, -1 }));
		assertEquals(-1, arraySign(new int[] { 41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13,
				32, 42, 43, 83, 78, 82, 70, 15, -41 }));
	}

//	public static void main(String[] args) {
//		Map<Integer, Integer> map = new HashMap<>();
//		System.out.println(map.getOrDefault(1, 0));
//	}

}
