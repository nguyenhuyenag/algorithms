package linked;

import org.junit.jupiter.api.Test;
import util.LinkedListTestUtils;

import java.util.Queue;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Gộp 2 danh sách sắp xếp
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (ListNode c = l1; c != null; c = c.next) {
            pq.add(c.val);
        }
        for (ListNode c = l2; c != null; c = c.next) {
            pq.add(c.val);
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        // Duyệt đồng thời 2 danh sách, so sánh giá trị và chèn vào kết quả
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Kiểm tra đã duyệt hết hết 2 danh sách chưa
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.of(1, 2, 4);
        ListNode l2 = ListNode.of(1, 3, 4);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(1, 1, 2, 3, 4, 4), mergeTwoLists(l1, l2));
    }

}
