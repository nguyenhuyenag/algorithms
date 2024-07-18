package incomplete;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://www.codewars.com/kata/5672682212c8ecf83e000050/

    Consider a sequence u where u is defined as follows:
        (1) The number u(0) = 1 is the first one in u.
        (2) Với mỗi x thuộc u, thì y = 2x + 1 và z = 3x + 1 cũng thuộc u.
    There are no other numbers in u.
 */
public class TwiceLinear {

    public static int dblLinear0(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> seen = new HashSet<>();

        pq.add(1);
        seen.add(1);

        int value = 1;
        for (int i = 0; i <= n; i++) {
            value = pq.poll();
            int x2 = 2 * value + 1;
            int x3 = 3 * value + 1;

            if (seen.add(x2)) {
                pq.add(x2);
            }
            if (seen.add(x3)) {
                pq.add(x3);
            }
        }

        return value;
    }

    public static int dblLinear(int n) {
        int[] u = new int[n + 1];
        u[0] = 1;
        int i = 0, j = 0;
        for (int k = 1; k <= n; k++) {
            int y = 2 * u[i] + 1;
            int z = 3 * u[j] + 1;
            u[k] = Math.min(y, z);
            if (u[k] == y) {
                i++;
            }
            if (u[k] == z) {
                j++;
            }
        }
        return u[n];
    }

    @Test
    public void test() {
        assertEquals(22, dblLinear(10));
        assertEquals(57, dblLinear(20));
        assertEquals(91, dblLinear(30));
        assertEquals(175, dblLinear(50));
    }

}
