package linked;

import org.junit.jupiter.api.Test;

import static util.LinkedListTestUtils.assertLinkedListEquals;

/*-
    https://leetcode.com/problems/remove-linked-list-elements/

    Cho danh sách liên kết đơn và một số nguyên val.
    Hãy xóa tất cả các node có Node.val == val và trả về head mới của danh sách.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode curr = result;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 6, 3, 4, 5, 6);
        assertLinkedListEquals(ListNode.of(1, 2, 3, 4, 5), removeElements(head, 6));
    }

}
