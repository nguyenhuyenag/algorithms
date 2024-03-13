package leetcode.array;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 *
 * Chia một mảng thành các mảng con sao cho các phần tử trong các mảng con không
 * trùng nhau [1,3,4,1,2,3,1] -> [[1,3,4,2],[1,3],[1]]
 *
 * Note: Số lượng mảng con tối đa = max frquency
 */
public class ConvertAnArray1Dto2D {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Counter
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Số lượng mảng con tối đa = max frquency
        int max_frequency = Collections.max(counter.values());

        for (int i = 0; i < max_frequency; i++) {
            List<Integer> subList = new ArrayList<>();
            // Ở mỗi lần nếu count > 0 thì lấy ra và thêm vào subList
            counter.forEach((num, count) -> {
                if (count > 0) {
                    subList.add(num);
                    counter.put(num, count - 1);
                }
            });
            result.add(subList);
        }

        return result;
    }

    @Test
    public void testSomething() {
        List<List<Integer>> matrix = findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
        System.out.println(Arrays.toString(matrix.toArray()));
    }

//	public List<List<Integer>> findMatrix_OK(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//
//		// Lưu trữ các phần tử khác nhau
//		Set<Integer> keys = new HashSet<>();
//
//		// Đếm số lượng các phần từ khác nhau
//		Map<Integer, Integer> counter = new HashMap<>();
//		for (int e : nums) {
//			counter.put(e, counter.getOrDefault(e, 0) + 1);
//			keys.add(e);
//		}
//
//		// Duyệt qua keys, nếu vẫn còn giá trị thì sẽ chia nó vào mảng con
//		while (!counter.isEmpty()) {
//			List<Integer> row = new ArrayList<>();
//			for (int key : keys) {
//				if (counter.containsKey(key)) {
//					row.add(key);
//					int value = counter.get(key);
//					if (--value == 0) { // Nếu sau khi chia mà còn lại 0
//						counter.remove(key); // thì xóa nó khỏi counter
//					} else {
//						counter.put(key, value);
//					}
//				}
//			}
//			result.add(row);
//		}
//		return result;
//	}

}
