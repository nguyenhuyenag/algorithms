package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public int removeDuplicates(int[] nums) {
        nums = Arrays.stream(nums).distinct().toArray();
        return nums.length;
    }

    @Test
    public void test() {

    }

}
