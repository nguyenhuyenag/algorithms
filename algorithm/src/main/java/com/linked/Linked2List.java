package com.linked;

public class Linked2List {

	Node head; // head of list
	Node tail; // tail of list

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode will become new tail of the list
			tail = newNode;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			// newNode will be added before head such that newNode next will point to head
			newNode.next = head;
			// newNode will become new head of the list
			head = newNode;
		}
	}

//	public void addFirst(int data) {
//		Node new_node = new Node(data);
//		new_node.next = head;
//		head = new_node;
//	}

	public void showList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		// System.out.print("Null" + "\n");
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

	public static void main(String[] args) {
		Linked2List list = new Linked2List(); // Create an empty list

		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);

//		list.add(1);
//		list.add(2);
//		list.add(3);

		// System.out.println("Size: " + list.length());
		list.showList();

		// System.out.println("Contain: " + list.contains(5));

		/*- Three nodes have been allocated dynamically. 
		We have references to these three blocks as head,   
		second and third 
		
		  llist.head        second              third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  | null |     | 2  | null |     |  3 | null | 
		+----+------+     +----+------+     +----+------+ */

		/*-  Now next of the first Node refers to the second.  So they 
		both are linked. 
		
		  llist.head         second            third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  |  o-------->| 2  | null |     |  3 | null | 
		+----+------+     +----+------+     +----+------+ */

		/*- Now next of the second Node refers to third.  So all three 
		nodes are linked. 
		
		  llist.head         second             third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  |  o-------->| 2  |  o-------->|  3 | null | 
		+----+------+     +----+------+     +----+------+ */

	}

}
