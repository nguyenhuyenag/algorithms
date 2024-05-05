package leetcode.linked;

import leetcode.util.LinkedListTestUtils;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/partition-list/
 *
 * Cho danh sách liên kết và số thực x, sắp xếp lại danh sách sao cho các số < k ở đầu,
 * các số còn lại >= k thì ở cuối nhưng vẫn giữ nguyên thứ tự
 */
public class PartitionList {

    public ListNode partition(ListNode head, int k) {
        ListNode dumpy = new ListNode(1_000);
        ListNode current = dumpy;
        for (ListNode c = head; c != null; c = c.next) {
            if (c.val < k) {
                current.next = new ListNode(c.val);
                current = current.next;
            }
        }
        for (ListNode c = head; c != null; c = c.next) {
            if (c.val >= k) {
                current.next = new ListNode(c.val);
                current = current.next;
            }
        }
        return dumpy.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 4, 3, 2, 5, 2);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(1, 2, 2, 4, 3, 5), partition(head, 3));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(2, 1);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(1, 2), partition(head, 2));
    }
}
