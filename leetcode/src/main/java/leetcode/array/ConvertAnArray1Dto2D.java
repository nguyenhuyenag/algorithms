package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 *
 * Chia một mảng thành các mảng con sao cho các phần tử trong các mảng con không
 * trùng nhau [1,3,4,1,2,3,1] -> [[1,3,4,2],[1,3],[1]]
 * 
 * Note: Số lượng mảng con tối đa = số lần xuất hiện tối đa của phần từ nào đó
 */
public class ConvertAnArray1Dto2D {

	public List<List<Integer>> findMatrix(int[] nums) {

		// Lưu trữ các phần tử khác nhau
		Set<Integer> keys = new HashSet<>();
		List<List<Integer>> ans = new ArrayList<>();

		// Đếm số lượng các phần từ khác nhau
		Map<Integer, Integer> numCount = new HashMap<>();
		for (int e : nums) {
			keys.add(e);
			numCount.put(e, numCount.getOrDefault(e, 0) + 1);
		}

		// Duyệt qua keys, nếu vẫn còn giá trị thì sẽ chia nó vào mảng con
		while (!numCount.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			for (int key : keys) {
				if (numCount.containsKey(key)) {
					row.add(key);
					int value = numCount.get(key);
					if (--value == 0) { // Nếu sau khi chia mà còn lại 0
						numCount.remove(key); // thì xóa nó khỏi numCount
					} else {
						numCount.put(key, value);
					}
				}
			}
			ans.add(row);
		}

		return ans;
	}

	@Test
	public void testSomething() {
		// assertEquals(10, findIt(new int[] { 10 }));
		findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 });
		// findMatrix(new int[] { 1,2,3,4 });
	}

}
