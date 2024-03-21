package com.linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

/**
 * Danh sách liên kết đơn
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
     * add() = addLast()
     */
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = this; // Gán con trỏ là node hiện tại
        while (current.next != null) {
            current = current.next; // Dời con trỏ đến cuối danh sách
        }
        current.next = newNode; // Liên kết node cuối với node mới
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
