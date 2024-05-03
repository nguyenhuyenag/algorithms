package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public double[] tribonacci(double[] s, int n) {
        double[] tritab = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            tritab[i] = tritab[i - 1] + tritab[i - 2] + tritab[i - 3];
        }
        return tritab;

    }

    @Test
    public void sampleTests() {
    }

}
