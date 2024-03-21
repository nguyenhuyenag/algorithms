package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static leetcode.linked.ListNode.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public StringBuilder asString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }
        return builder.reverse();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // StringBuilder n1 = asString(l1);
        // StringBuilder n2 = asString(l2);
        BigInteger b1 = new BigInteger(asString(l1).toString());
        BigInteger b2 = new BigInteger(asString(l2).toString());
        BigInteger sum = b1.add(b2);
        return null;
    }

    /**
     * Create Data & Test
     */
    public List<Integer> call(int[] val1, int[] val2) {
        ListNode l1 = of(val1);
        ListNode l2 = of(val2);
        return null;
    }

    @Test
    public void test() {
        ListNode test1 = of(new int[]{7, 0, 8});
        assertIterableEquals(test1.toList(), call(new int[]{2, 4, 3}, new int[]{5, 6, 4}));
    }

}
