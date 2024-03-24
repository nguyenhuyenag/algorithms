package com.linked;

import java.util.StringJoiner;

/*-
		Three nodes have been allocated dynamically.
		We have references to these three blocks as head,
		second and third

		  list.head         second             third
			 |                 |                 |
			 |                 |                 |
		+----+------+     +----+------+     +----+------+
		| 1  | null |     | 2  | null |     |  3 | null |
		+----+------+     +----+------+     +----+------+

		Now next of the first Node refers to the second.  So they
		both are linked.

		  list.head         second            third
			 |                 |                 |
			 |                 |                 |
		+----+------+     +----+------+     +----+------+
		| 1  |  o-------->| 2  | null |     |  3 | null |
		+----+------+     +----+------+     +----+------+

		Now next of the second Node refers to third.  So all three
		nodes are linked.

		  list.head          second            third
		     |                 |                 |
		     |                 |                 |
		+----+------+     +----+------+     +----+------+
		| 1  |  o-------->| 2  |  o-------->|  3 | null |
		+----+------+     +----+------+     +----+------+
*/
public class Linked2List {

    ListNode head; // head of list
    ListNode tail; // tail of list

    public static void main(String[] args) {
        Linked2List list = new Linked2List(); // Create an empty list

        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(0);
        list.addFirst(-1);
        list.addFirst(-3);

        // System.out.println("Size: " + list.length());
        list.showList();

        // System.out.println("Contain: " + list.contains(5));
    }

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            // If list is empty, both head and tail will point to new node
            head = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
        }
        tail = newNode;
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            // head = newNode;
            tail = newNode;
        } else {
            // newNode will be added before head such that newNode next will point to head
            newNode.next = head;
            // newNode will become new head of the list
            // head = newNode;
        }
        head = newNode;
    }

//	public int length() {
//		int length = 0;
//		Node temp = head;
//		while (temp != null) {
//			length++;
//			temp = temp.next;
//		}
//		return length;
//	}

//	public boolean contains(int data) {
//		Node temp = head;
//		while (temp != null) {
//			if (temp.data == data) {
//				return true;
//			}
//			temp = temp.next;
//		}
//		return false;
//	}

    public void showList() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        ListNode current = this.head;
        while (current != null) {
            joiner.add(String.valueOf(current.val));
            current = current.next;
        }
        System.out.println(joiner.toString());
    }

}
