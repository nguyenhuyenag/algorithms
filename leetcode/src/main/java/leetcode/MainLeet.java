package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */
public class MainLeet {

//    public int[] rearrangeArray(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//        LinkedList<Integer> negArr = new LinkedList<>();
//        LinkedList<Integer> posArr = new LinkedList<>();
//        for (int v : nums) {
//            if (v > 0) {
//                posArr.push(v);
//            } else {
//                negArr.push(v);
//            }
//        }
//        while (!posArr.isEmpty() && !negArr.isEmpty()) {
//            result.add(posArr.pollLast());
//            result.add(negArr.pollLast());
//        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }

    @Test
    public void test() {
        // assertArrayEquals(new int[]{3, -2, 1, -5, 2, -4}, rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
        // assertArrayEquals(new int[]{1, -1}, rearrangeArray(new int[]{-1, 1}));
    }

}
