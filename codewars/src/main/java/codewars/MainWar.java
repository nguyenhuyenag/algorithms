package codewars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public static int sum(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        IntSummaryStatistics summary = Arrays.stream(nums).summaryStatistics();
        return (int) (summary.getSum() - summary.getMin() - summary.getMax());
    }

}
