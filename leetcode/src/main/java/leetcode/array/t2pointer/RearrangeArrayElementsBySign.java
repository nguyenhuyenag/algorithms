package leetcode.array.t2pointer;


import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 *
 * Cho mảng số nguyên, sắp xếp lại theo thứ tự dương, âm xen kẽ
 *
 * Ví dụ: [3,1,-2,-5,2,-4] -> [3,1,2], [-2,-5,-4] -> [3,-2,1,-5,2,-4]
 *
 * Số âm và số dương đều có số lượng bằng nhau
 */
public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray_OK1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> negArr = new LinkedList<>();
        LinkedList<Integer> posArr = new LinkedList<>();
        for (int v : nums) {
            if (v > 0) {
                posArr.push(v);
            } else {
                negArr.push(v);
            }
        }
        while (!posArr.isEmpty() && !negArr.isEmpty()) {
            result.add(posArr.pollLast());
            result.add(negArr.pollLast());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] rearrangeArray_OK2(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> negArr = new ArrayList<>();
        List<Integer> posArr = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                posArr.add(num);
            } else {
                negArr.add(num);
            }
        }
        int i = 0, posIndex = 0, negIndex = 0;
        while (posIndex < posArr.size() && negIndex < negArr.size()) {
            result[i++] = posArr.get(posIndex++);
            result[i++] = negArr.get(negIndex++);
        }
        return result;
    }

    public int[] rearrangeArray(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int i = 0, posIndex = 0, negIndex = 0;
        // posIndex chỉ duyệt qua các số > 0, negIndex chỉ duyệt các số < 0
        while (i < len) {
            // Tìm đến số dương gần nhất
            while (posIndex < len && arr[posIndex] < 0) {
                posIndex++;
            }
            // Tìm đến số âm gần nhất
            while (negIndex < len && arr[negIndex] > 0) {
                negIndex++;
            }
            // Đẩy kết quả vào result
            result[i++] = arr[posIndex++];
            result[i++] = arr[negIndex++];
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, -1}, rearrangeArray(new int[]{-1, 1}));
        assertArrayEquals(new int[]{3, -2, 1, -5, 2, -4}, rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
    }

}
