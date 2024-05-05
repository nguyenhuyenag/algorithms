package leetcode.linked;

import org.junit.jupiter.api.Test;

import static leetcode.util.LinkedListTestUtils.*;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Xóa các phần tử giống nhau (chừa lại môt) khỏi danh sách
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(1_000); // -100 <= Node.val <= 100
        ListNode current = dummy;
        while (head != null) {
            if (current.val != head.val) {
                current.next = new ListNode(head.val);
                current = current.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    @Test
    public void test1() {
        assertLinkedListEquals(ListNode.of(1, 2, 3), deleteDuplicates(ListNode.of(1, 2, 2, 3)));
    }

    @Test
    public void test2() {
        assertLinkedListEquals(ListNode.of(1, 2, 3), deleteDuplicates(ListNode.of(1, 1, 2, 3, 3)));
    }

}
