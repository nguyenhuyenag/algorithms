package com.linked;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Definition for singly-linked list
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode of(Integer... vals) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int val : vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next;
    }

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

    public int size() {
        int size = 0;
        for (ListNode pointer = this; pointer != null; pointer = pointer.next) {
            size++;
        }
        return size;
    }

    /**
     * Tạo node mới lưu giá trị của head, thay val vào head sau đó chèn node mới trở lại
     */
    public void addFirst(int val) {
        // Backup head
        ListNode oldHead = new ListNode(this.val);
        // Thay thế val thành head
        this.val = val;
        // Trỏ oldHead vao node 1 (this là head -> this.next là node 1)
        oldHead.next = this.next;
        // Trỏ head vào oldHead
        this.next = oldHead;
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this; // Gán con trỏ là node hiện tại
        while (current.next != null) {
            current = current.next; // Dời con trỏ đến cuối danh sách
        }
        current.next = newNode; // Liên kết node cuối với node mới
    }

//    /**
//     * Thêm node vào đầu danh sách. Có cách không return?
//     */
//    public ListNode addFirstX(int val) {
//        ListNode newNode = new ListNode(val);
//        newNode.next = this;
//        return newNode;
//    }

    /**
     * Chèn node mới vào vị trí node [1, n] (xem head là node 0)
     */
    public void insert(int index, int val) {
        if (index < 0) {
            return; // Invalid index, do nothing
        }
        if (index == 0) {
            this.addFirst(val);
            return;
        }
        int i = 0;
        ListNode current = this;
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }
        if (current != null) {
            ListNode newNode = new ListNode(val);
            ListNode next = current.next;
            current.next = newNode;
            newNode.next = next;
        }
    }

    public ListNode reverse() {
        ListNode prev = null;
        ListNode current = this;
        while (current != null) {
            ListNode nextNode = current.next; // Lưu node tiếp theo trước khi di chuyển
            current.next = prev; // Đảo ngược con trỏ
            // Di chuyển pre, current đến vị trí tiếp theo trong danh sách
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    private int indexOf1(int val) {
        int i = 0;
        for (ListNode current = this; current != null; current = current.next, i++) {
            if (current.val == val) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfByRecusive(ListNode listNode, int val, int index) {
        if (listNode == null) return -1;
        if (listNode.val == val) return index;
        return indexOfByRecusive(listNode.next, val, ++index);
    }

    public int indexOf(int val) {
        // return indexOf1(val);
        return indexOfByRecusive(this, val, 0);
    }

    public void removeByIndex(int index) {
        ListNode current = this;
    }

    public boolean equals(ListNode l2) {
        ListNode current1 = this;
        ListNode current2 = l2;
        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        // If both lists reach the end at the same time, they are equal
        return current1 == null && current2 == null;
    }

    public void showList() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        ListNode current = this;
        while (current != null) {
            joiner.add(String.valueOf(current.val));
            current = current.next;
        }
        System.out.println(joiner.toString());
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
