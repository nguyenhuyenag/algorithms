package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Đảo ngược danh sách liên kết
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        ListNode current = head;
        while (current != null) {
            // Lưu node kế tiếp trước khi di chuyển
            ListNode nextNode = current.next;
            // Đảo ngược con trỏ
            current.next = rev;

            // Di chuyển con trỏ và rev đến vị trí tiếp theo
            rev = current;
            current = nextNode;
        }
        return rev;
    }

    /**
     * Create Data & Test
     */
    public List<Integer> call(int[] vals) {
        ListNode head = ListNode.of(vals);
        head = reverseList(head);
        return head.toList();
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(5, 4, 3, 2, 1), call(new int[]{1, 2, 3, 4, 5}));
        assertIterableEquals(List.of(2, 1), call(new int[]{1, 2}));
    }

}
