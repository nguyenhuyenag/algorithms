package linked;

import org.junit.jupiter.api.Test;

import static util.LinkedListTestUtils.*;

/*
    https://leetcode.com/problems/merge-nodes-in-between-zeros/

    Cho danh sách liên kết có head và tail đều là giá trị 0. Gộp các các node ở giữa 2 node 0.

    Input: head = [0,3,1,0,4,5,2,0]
    Output: [4,11]
    - The sum of the nodes marked in green: 3 + 1 = 4.
    - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
 */
public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;
        head = head.next;

        for (ListNode c = head; c != null; c = c.next) {
            if (c.val == 0) {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            } else {
                sum += c.val;
            }
        }

        return result.next;
    }

    @Test
    public void test1() {
        ListNode l1 = mergeNodes(ListNode.of(0, 3, 1, 0, 4, 5, 2, 0));
        ListNode l2 = ListNode.of(4, 11);
        assertLinkedListEquals(l1, l2);
    }

    @Test
    public void test2() {
        ListNode l1 = mergeNodes(ListNode.of(0, 1, 0, 3, 0, 2, 2, 0));
        ListNode l2 = ListNode.of(1, 3, 4);
        assertLinkedListEquals(l1, l2);
    }

}
