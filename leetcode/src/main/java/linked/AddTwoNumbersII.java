package linked;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.LinkedListTestUtils;

import java.util.Stack;

import static util.LinkedListTestUtils.*;

/*
    https://leetcode.com/problems/add-two-numbers-ii/

    Công 2 danh sách liên kết

        7  2  4  3
           5  6  4
       ------------
        7  8  0  7
 */
public class AddTwoNumbersII {

    public Stack<Integer> toStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode p = listNode; p != null; p = p.next) {
            stack.push(p.val);
        }
        return stack;
    }

    public ListNode addTwoNumbers_OK(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = toStack(l1);
        Stack<Integer> stack2 = toStack(l2);
        // System.out.println("stack1 = " + stack1);
        // System.out.println("stack2 = " + stack2);
        Stack<Integer> result = new Stack<>();
        int rem = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + rem;
            result.push(sum % 10);
            rem = sum / 10;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + rem;
            result.push(sum % 10);
            rem = sum / 10;
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + rem;
            result.push(sum % 10);
            rem = sum / 10;
        }
        if (rem > 0) {
            result.push(rem);
        }
        // System.out.println("=> " + result);
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!result.isEmpty()) {
            current.next = new ListNode(result.pop());
            current = current.next;
        }
        return head.next; // Bỏ nút đầu tiên
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = toStack(l1);
        Stack<Integer> stack2 = toStack(l2);
        Stack<Integer> result = new Stack<>();
        int rem = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || rem > 0) {
            int sum = rem;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            result.push(sum % 10);
            rem = sum / 10;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!result.isEmpty()) {
            current.next = new ListNode(result.pop());
            current = current.next;
        }
        return head.next; // Bỏ nút đầu tiên
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.of(7, 2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        assertLinkedListEquals(ListNode.of(7, 8, 0, 7), addTwoNumbers(l1, l2));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.of(0);
        ListNode l2 = ListNode.of(0);
        assertLinkedListEquals(ListNode.of(0), addTwoNumbers(l1, l2));
    }

}
