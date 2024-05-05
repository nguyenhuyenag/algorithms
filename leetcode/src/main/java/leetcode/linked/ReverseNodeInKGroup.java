package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static leetcode.util.LinkedListTestUtils.*;

/*-
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Cho danh sách và số nguyên k. Đảo ngược danh sách ở các nhóm k phần tử (không giao nhau)
 *
 * Input: [1, 2, 3, 4, 5] , k = 2 -> [2, 1, 4, 3, 5]
 *
 * Input: [1, 2, 3, 4, 5] , k = 3 -> [3, 2, 1, 4, 5]
 */
public class ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode listNode, int k) {
        // Get all list
        List<Integer> list = new ArrayList<>();
        ListNode current = listNode;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Reverse
        for (int i = 0; i < list.size(); i += k) {
            int left = i;
            int right = Math.min(i + k - 1, list.size() - 1);
            if (right - left + 1 == k) { // Kiểm tra xem nhóm có đủ k phần tử không
                while (left < right) {
                    Collections.swap(list, left, right);
                    left++;
                    right--;
                }
            }
        }

        // Create result
        ListNode head = new ListNode(0);
        current = head;
        for (int val : list) {
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertLinkedListEquals(ListNode.of(2, 1, 4, 3, 5), reverseKGroup(head, 2));
    }

    @Test
    public void test2() {
        assertLinkedListEquals(ListNode.of(2, 1), reverseKGroup(ListNode.of(1, 2), 2));
    }

}
