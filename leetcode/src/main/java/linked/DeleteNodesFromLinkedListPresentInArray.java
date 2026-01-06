package linked;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static util.LinkedListTestUtils.assertLinkedListEquals;

/*-
    https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

    Cho mảng số nguyên và một danh sách liên kết, trả về danh sách sau khi xóa
    các node để các phần tử trong danh sách tương tưng với phần tử trong mảng.
 */
public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        // Gán vào set để tra cứu O(1)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(-1); // Node giả
        ListNode cur = dummy;

        for (ListNode node = head; node != null; node = node.next) {
            if (!set.contains(node.val)) {
                cur.next = node;
                cur = cur.next;
            }
        }

        // Cắt đuôi để tránh nối dư
        cur.next = null;

        return dummy.next; // Bỏ giá trị -1 lúc khởi tạo
    }

    @Test
    public void test1() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertLinkedListEquals(ListNode.of(4, 5), modifiedList(new int[]{1, 2, 3}, head));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(1, 2, 1, 2, 1, 2);
        assertLinkedListEquals(ListNode.of(2, 2, 2), modifiedList(new int[]{1}, head));
    }

}
