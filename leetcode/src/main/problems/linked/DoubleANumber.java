package linked;

import org.junit.jupiter.api.Test;

import static util.LinkedListTestUtils.assertLinkedListEquals;

/**
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
 *
 * Cho danh sách liên kết đại diện cho một số nguyên n (trái qua phải). Trả về kết của
 * 2n cũng dưới dạn danh sách liên kết
 */
public class DoubleANumber {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;

            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverseList(head);
        int rem = 0;
        for (ListNode current = reversed; current != null; current = current.next) {
            int newValue = current.val * 2 + rem;
            current.val = newValue % 10;
            rem = newValue / 10;
            if (rem > 0 && current.next == null) {
                current.next = new ListNode(rem);
                break;
            }
        }
        return reverseList(reversed);
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.of(1, 2, 3);
        ListNode l2 = ListNode.of(2, 4, 6);
        doubleIt(l1).showList();
        l2.showList();
        // assertLinkedListEquals(l2, doubleIt(l1));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.of(1, 8, 9);
        ListNode l2 = ListNode.of(3, 7, 8);
        assertLinkedListEquals(l2, doubleIt(l1));
    }

    @Test
    public void test3() {
        ListNode l1 = ListNode.of(9, 9, 9);
        ListNode l2 = ListNode.of(1, 9, 9, 8);
        assertLinkedListEquals(l2, doubleIt(l1));
    }

    public ListNode doubleIt_OK(ListNode head) {
        ListNode reversed = reverseList(head);
        ListNode current = reversed;
        int rem = 0;
        while (current != null) {
            int newValue = current.val * 2 + rem;
            current.val = newValue % 10;
            rem = newValue / 10;
            if (rem > 0 && current.next == null) {
                current.next = new ListNode(rem);
                break;
            }
            current = current.next;
        }
        return reverseList(reversed); // Return the list to its original order
    }

}
