package com.linked;

public class LinkedList {

	Node head; // head of the list

	private static class Node {
		int data;
		Node next;

		// Constructor to create a new node. Next is by default initialized as null
		public Node(int d) {
			this.data = d;
			next = null;
		}
	}

	public void add(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("Null" + "\n");
	}

	public int length() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public boolean contains(int data) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); // Create an empty list

		list.add(1);
		list.add(2);
		list.add(3);

		list.printList();
		System.out.println("Size: " + list.length());
		System.out.println("Contain: " + list.contains(5));

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
