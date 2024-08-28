package com.leetcode.problems;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

public class RemoveNthNodeFromEndofList {

	/**
	 * Removes the nth node from the end of the list and returns the head of the
	 * modified list.
	 * 
	 * @param head The head of the singly-linked list.
	 * @param n    The position from the end of the list of the node to be removed.
	 * @return The head of the list after removing the nth node from the end.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Initialize two pointers and a variable to store the length of the list
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		int length = 0;

		// Calculate the length of the linked list
		while (fastPointer != null) {
			length++;
			fastPointer = fastPointer.next;
		}

		// Reset the fastPointer to head and set a counter
		fastPointer = head;
		int count = 0;

		// Move the fastPointer to the position of the node to be removed
		while (length - count != n && fastPointer != null) {
			count++;
			fastPointer = fastPointer.next;
		}

		// If the node to be removed is the head, return the next node as the new head
		if (head.equals(fastPointer)) {
			return head.next;
		}

		// Traverse the list to find the node before the node to be removed
		while (!fastPointer.equals(slowPointer.next)) {
			slowPointer = slowPointer.next;
		}

		// Remove the nth node from the end by adjusting the pointers
		slowPointer.next = fastPointer.next;

		// Return the head of the modified list
		return head;
	}
}
