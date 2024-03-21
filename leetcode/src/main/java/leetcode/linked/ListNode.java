package leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * CRUD
     */
    public static ListNode of(int[] vals) {
        ListNode head = null;
        ListNode current = null;
        for (int val : vals) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                current.next = newNode;
            }
            current = newNode;
        }
        return head;
    }

    public List<Integer> toList() {
        List<Integer> result = new ArrayList<>();
        ListNode current = this;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }

}
