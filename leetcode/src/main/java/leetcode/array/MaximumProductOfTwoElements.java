package leetcode.array;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * 
 * (A - 1)*(B - 1) = max => A * B = max => max * secondMax = ans
 */
public class MaximumProductOfTwoElements {

//	public int maxProduct0(int[] nums) {
//		int length = nums.length;
//		int max = Integer.MIN_VALUE;
//		for (int i = 0; i < length; i++) {
//			for (int j = i + 1; j < length; j++) {
//				max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
//			}
//		}
//		return max;
//	}

	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int x : nums) {
			if (x > max) {
				secondMax = max;
				max = x;
			} else if (x > secondMax) {
				secondMax = x;
			}
		}
		return (max - 1) * (secondMax - 1);
	}

	public static void main(String[] args) {
		MaximumProductOfTwoElements m = new MaximumProductOfTwoElements();
		// m.maxProduct(new int[] { 3, 4, 5, 2 });
		// m.maxProduct(new int[] { 1,5,4,5 });
		m.maxProduct(new int[] { 3, 7 });
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
