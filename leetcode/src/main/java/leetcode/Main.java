package leetcode;

/**
 */
public class Main {

	public int maxProduct(int[] nums) {
		int length = nums.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.maxProduct(new int[] { 3, 4, 5, 2 });
		// m.maxProduct(new int[] { 1,5,4,5 });
		m.maxProduct(new int[] { 3, 7 });
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
