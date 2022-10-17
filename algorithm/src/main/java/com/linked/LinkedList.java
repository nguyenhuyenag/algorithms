package com.linked;

public class LinkedList {

	Node head; // head of the list

	/* Linked list Node */
	static class Node {

		int data;
		Node next;

		// Constructor to create a new node
		// Next is by default initialized as null
		public Node(int d) {
			this.data = d;
			next = null;
		}

	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkedList llist = new LinkedList();

		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		/*- Three nodes have been allocated dynamically. 
		We have references to these three blocks as head,   
		second and third 
		
		  llist.head        second              third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  | null |     | 2  | null |     |  3 | null | 
		+----+------+     +----+------+     +----+------+ */

		llist.head.next = second; // Link first node with the second node

		/*-  Now next of the first Node refers to the second.  So they 
		both are linked. 
		
		  llist.head         second            third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  |  o-------->| 2  | null |     |  3 | null | 
		+----+------+     +----+------+     +----+------+ */

		second.next = third; // Link second node with the third node

		/*- Now next of the second Node refers to third.  So all three 
		nodes are linked. 
		
		  llist.head         second             third 
		     |                 |                 | 
		     |                 |                 | 
		+----+------+     +----+------+     +----+------+ 
		| 1  |  o-------->| 2  |  o-------->|  3 | null | 
		+----+------+     +----+------+     +----+------+ */

		llist.printList();
	}

}
