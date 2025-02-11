package linked;

import org.junit.jupiter.api.Test;
import util.LinkedListTestUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Gộp k danh sách sắp xếp
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (ListNode l : lists) {
            for (ListNode c = l; c != null; c = c.next) {
                pq.add(c.val);
            }
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!pq.isEmpty()) {
            ListNode newNode = new ListNode(pq.poll());
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.of(1, 2, 4);
        ListNode l2 = ListNode.of(1, 3, 4);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(1, 1, 2, 3, 4, 4), mergeKLists(new ListNode[]{l1, l2}));
    }

}
