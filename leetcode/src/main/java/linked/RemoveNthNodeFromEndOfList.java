package linked;

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
     * Tìm vị trí cần xóa. Duyệt danh sách và bỏ qua vị trí cần xóa
     */
    public ListNode removeNthFromEnd_OK(ListNode head, int n) {
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

    public ListNode removeNthFromEnd(ListNode listNode, int k) {
        // Kích thước của danh sách
        int size = sizeOf(listNode);
        // Tạo node mới và gán node hiện tại vào node mới
        ListNode head = new ListNode(0);
        head.next = listNode;
        ListNode current = head;
        // Tìm vị trí trước vị trí cần xóa
        for (int i = 0; i < size - k; i++) {
            current = current.next;
        }
        // Xóa node bằng cách bỏ qua nó
        current.next = current.next.next;
        return head.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        ListNode listNode = removeNthFromEnd(head, 2);
        listNode.showList();
    }

}
