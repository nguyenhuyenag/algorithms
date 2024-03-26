package leetcode.linked;

import leetcode.linked.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Xóa node thứ n tính từ cuối danh sách
 */
public class RemoveNthNodeFromEndOfList {

    // Tìm kích thước của danh sách
    public int sizeOf(ListNode head) {
        int size = 0;
        for (ListNode c = head; c != null; c = c.next) {
            size++;
        }
        return size;
    }

    /**
     * Tìm vị trí cần xóa. Duyệt danh sách bỏ qua vị trí cần xóa
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Kích thước của danh sách
        int size = sizeOf(head);

        ListNode result = new ListNode(0);
        ListNode resultPointer = result;

        int index = 0;
        ListNode current = head;
        while (current != null) {
            if (index != size - n) { // (size - n) là vị trí sẽ bỏ qua (cần xóa)
                ListNode newNode = new ListNode(current.val);
                resultPointer.next = newNode;
                resultPointer = newNode;
            }
            current = current.next;
            index++;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        ListNode listNode = removeNthFromEnd(head, 2);
        listNode.showList();
    }

}
