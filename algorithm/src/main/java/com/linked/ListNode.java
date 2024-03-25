package com.linked;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this; // Gán con trỏ là node hiện tại
        while (current.next != null) {
            current = current.next; // Dời con trỏ đến cuối danh sách
        }
        current.next = newNode; // Liên kết node cuối với node mới
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

    /**
     * Thêm node vào đầu danh sách. Có cách không return?
     */
    public ListNode addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this;
        return newNode;
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

}
