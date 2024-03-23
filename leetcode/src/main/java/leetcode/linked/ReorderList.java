package leetcode.linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*-
 * https://leetcode.com/problems/reorder-list/
 *
 * Cho danh sách dạng
 *      L0 → L1 → ... → L_{n - 1} → Ln
 * Sắp xếp danh sách lại theo dạng
 *      L0 → Ln → L1 → L_{n - 1} → L2 → L_{n - 2} → ...
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // Extract values to List
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        // Reorder list
        current = head;
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // For right
            current.val = list.get(left++);
            current = current.next;
            // For right
            current.val = list.get(right--);
            current = current.next;
        }
        // Handle the case when the list length is odd
        if (left == right) {
            current.val = list.get(left);
        }
    }

    @Test
    public void test() {
        ListNode head = ListNode.of(new int[]{1, 2, 3, 4});
        reorderList(head);
        head.showList();
    }

}
