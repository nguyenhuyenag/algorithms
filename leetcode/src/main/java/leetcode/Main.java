package leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void doTest() {
        Queue min =  new PriorityQueue<>();
        int[] nums = new int[]{5, 6, 2, 7, 4};
        for (int v : nums) {
            // min.add(v);
            min.add(v);
        }
        System.out.println(min.poll());
    }

}
