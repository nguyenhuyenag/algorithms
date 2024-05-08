package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/relative-ranks/

    Cho mảng điểm số duy nhất. In ra thứ hạng tương ứng

        The 1st place athlete's rank is "Gold Medal".
        The 2nd place athlete's rank is "Silver Medal"
        The 3rd place athlete's rank is "Bronze Medal"
        For the 4th -> x-th place athlete's rank is "x"

    Example 1:
        Input: score = [5,4,3,2,1]
        Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 */
public class RelativeRanks {

    public String getRank(int rank) {
        return switch (rank) {
            case 0 -> "Gold Medal";
            case 1 -> "Silver Medal";
            case 2 -> "Bronze Medal";
            default -> Integer.toString(rank + 1);
        };
    }

    public String[] findRelativeRanks(int[] score) {
        // <value, value_index>
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        int rank = 0;
        String[] answer = new String[score.length];
        // Điểm sẽ sắp xếp từ cao -> thấp, lấy ra điểm và get rank (rank sẽ tăng từ 0 -> ....)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            answer[index] = getRank(rank++);
        }
        return answer;
    }

    @Disabled
    @Test
    public void test1() {
        var relativeRanks = findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        assertArrayEquals(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}, relativeRanks);
    }

    @Test
    public void test2() {
        var relativeRanks = findRelativeRanks(new int[]{10, 3, 8, 9, 4});
        assertArrayEquals(new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"}, relativeRanks);
    }

    public Map<Integer, Integer> findOrder(int[] arr) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy, Comparator.reverseOrder());
        for (int i = 0; i < copy.length; i++) {
            resultMap.put(copy[i], i);
        }
        return resultMap;
    }

    public String[] findRelativeRanks_OK(int[] scores) {
        String[] answer = new String[scores.length];
        Map<Integer, Integer> ranks = findOrder(scores);
        for (int i = 0; i < scores.length; i++) {
            answer[i] = getRank(ranks.get(scores[i]));
        }
        // System.out.println("ranks = " + Arrays.toString(answer ));
        return answer;
    }

}
