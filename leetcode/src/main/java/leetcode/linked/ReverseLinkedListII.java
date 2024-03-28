package leetcode.linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static leetcode.linked.LinkedListTestUtils.*;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Đảo mảng trên đoạn 0 <= m, n <= length
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (ListNode c = head; c != null; c = c.next) {
            list.add(c.val);
        }
        while (left < right) {
            // Node đếm từ 1, còn index đếm từ 0
            int tmp = list.get(left - 1);
            list.set(left - 1, list.get(right - 1));
            list.set(right - 1, tmp);
            left++;
            right--;
        }
        ListNode dumpy = new ListNode(0);
        ListNode current = dumpy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dumpy.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertLinkedListEquals(ListNode.of(1, 4, 3, 2, 5), reverseBetween(head, 2, 4));
    }

}
