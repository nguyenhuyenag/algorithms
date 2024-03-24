package com.linked;

/**
 * Tìm điểm giữa của Linked List
 */
public class FastSlowPointer {

    public static void findMidleNode(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("slow.val = " + slow.val);
    }

    public static void main(String[] args) {
        ListNode head = com.linked.ListNode.of(1, 2, 3, 4, 5);
        findMidleNode(head);
    }

}
