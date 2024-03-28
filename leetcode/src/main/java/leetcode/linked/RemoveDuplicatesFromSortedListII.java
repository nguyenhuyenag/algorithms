package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static leetcode.linked.LinkedListTestUtils.assertLinkedListEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Xóa hết các phần tử giống nhau khỏi danh sách
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> counter = new LinkedHashMap<>();
        for (ListNode c = head; c != null; c = c.next) {
            counter.put(c.val, counter.getOrDefault(c.val, 0) + 1);
        }
        ListNode dummy = new ListNode(1_000); // -100 <= Node.val <= 100
        ListNode current = dummy;
        for (int key : counter.keySet()) {
            if (counter.get(key) == 1) {
                current.next = new ListNode(key);
                current = current.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test1() {
        assertLinkedListEquals(ListNode.of(1, 3), deleteDuplicates(ListNode.of(1, 2, 2, 3)));
    }

    @Test
    public void test2() {
        assertLinkedListEquals(ListNode.of(2), deleteDuplicates(ListNode.of(1, 1, 2, 3, 3)));
    }

}
