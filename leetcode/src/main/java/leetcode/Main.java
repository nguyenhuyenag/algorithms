package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Main {

	public int numIdenticalPairs(int[] nums) {
		int count = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (i < j && nums[i] == nums[j]) {
					count++;
					System.out.println(i + ", " + j);
				}
			}
		}
		return count;
	}

	@Test
	public void test() {
		assertEquals(4, numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		// assertEquals(6, numIdenticalPairs(new int[] { 1,1,1,1 }));
		// assertEquals(0, numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

}
