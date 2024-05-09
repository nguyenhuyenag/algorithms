package linked;

import org.junit.jupiter.api.Test;
import util.LinkedListTestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Xoay k phần tử về phía đầu danh sách
 */
public class RotateList {

    public int sizeOf(ListNode head) {
        int size = 0;
        for (ListNode c = head; c != null; c = c.next) {
            size++;
        }
        return size;
    }

    public ListNode moveOne(ListNode head) {
        ListNode node1 = new ListNode(head.val);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node1;
        return head.next;
    }

    public ListNode rotateRight_OK(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int n = sizeOf(head);
        if (n <= k) k = k % n; // Đảm bảo k luôn nhỏ hơn n
        int rotate = n - k; // Đổi từ số lần xoay bên trái sang số lần xoay bên phải
        for (int i = 0; i < rotate; i++) {
            head = moveOne(head);
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        for (ListNode c = head; c != null; c = c.next) {
            list.add(c.val);
        }
        Collections.rotate(list, k);
        ListNode dumpy = new ListNode(0);
        ListNode current = dumpy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dumpy.next;
    }

    @Test
    public void test1() {
        int k = 2;
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(4, 5, 1, 2, 3), rotateRight(head, k));
    }

    @Test
    public void test3() {
        int k = 1;
        ListNode head = ListNode.of(1, 2);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(2, 1), rotateRight(head, k));
    }

    @Test
    public void test2() {
        int k = 4;
        ListNode head = ListNode.of(0, 1, 2);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(2, 0, 1), rotateRight(head, k));
    }

}
