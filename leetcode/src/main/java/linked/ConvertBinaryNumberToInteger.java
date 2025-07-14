package linked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertBinaryNumberToInteger {

    public int getDecimalValue_OK(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder builder = new StringBuilder();
        for (ListNode p = head; p != null; p = p.next) {
            builder.append(p.val);
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    @Test
    public void test1() {
        ListNode l = ListNode.of(1, 0, 1);
        assertEquals(5, getDecimalValue(l));
    }

    @Test
    public void test2() {
        ListNode l = ListNode.of(0);
        assertEquals(0, getDecimalValue(l));
    }

}
