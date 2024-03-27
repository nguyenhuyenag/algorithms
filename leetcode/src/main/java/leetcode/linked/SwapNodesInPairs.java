package leetcode.linked;

import leetcode.linked.LinkedListTestUtils;
import leetcode.linked.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static leetcode.linked.LinkedListTestUtils.*;

public class SwapNodesInPairs {

    public ListNode swapPairs_OK(ListNode listNode) {
        ListNode current = listNode;
        List<Integer> list = new ArrayList<>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        for (int i = 0; i < list.size() - 1; i += 2) {
            Collections.swap(list, i, i + 1);
        }
        ListNode head = new ListNode(0);
        current = head;
        for (int val : list) {
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }

    public ListNode swapPairs(ListNode listNode) {
        ListNode head = new ListNode(0);
        head.next = listNode; // Gán node hiện tại vào head
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            curr.next = second;
            first.next = second.next;
            second.next = first;

            curr = curr.next.next;
        }
        return head.next; // Bỏ node 0 ban đầu khi khởi tạo
    }

    @Test
    public void test() {
        ListNode list = ListNode.of(1, 2, 3, 4);
        assertLinkedListEquals(ListNode.of(2, 1, 4, 3), swapPairs(list));
    }

}
