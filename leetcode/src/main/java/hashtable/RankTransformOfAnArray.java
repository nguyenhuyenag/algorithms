package hashtable;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/rank-transform-of-an-array/

    Thay thế các số nguyên bằng thứ tự (tự nhiên) của chúng.

    Ví dụ: [40, 10, 20, 30] -> [4, 1, 2, 3]
            40 là số lớn nhất (thứ 4, cuối cùng)
            10 là số nhỏ nhất (thứ 1)
            20 là số nhỏ nhì (thứ 2)
            30 là số nhỏ ba (thứ 4)
 */
public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        // Sắp xếp mảng (clone) để tìm vị trí
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int rank = 1;
        // Map để lưu rank của tương ứng của nó
        Map<Integer, Integer> rankMap = new HashMap<>();

        for (int x : sorted) {
            // Chỉ đánh dấu rank nếu nó chưa có trong map, ví dụ có 2 số giống nhau thì chỉ gán rank 1 lần
            if (!rankMap.containsKey(x)) {
                rankMap.put(x, rank++);
            }
        }

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{4, 1, 2, 3}, arrayRankTransform(new int[]{40, 10, 20, 30}));
        assertArrayEquals(new int[]{1, 1, 1}, arrayRankTransform(new int[]{100, 100, 100}));
        assertArrayEquals(new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3}, arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}));
    }

}
