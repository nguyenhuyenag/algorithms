package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * <p>
 * Kiểm tra xem linked list có phải đối xứng không
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean call(int[] vals) {
        ListNode head = ListNode.of(vals);
        return isPalindrome(head);
    }

    @Test
    public void test() {
        assertEquals(false, call(new int[]{1, 2}));
        assertEquals(true, call(new int[]{1, 2, 2, 1}));
        assertEquals(false, call(new int[]{1, 2, 3, 4}));
    }

    public boolean isPalindrome_OK(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode curent = head;
        while (curent != null) {
            builder.append(curent.val);
            curent = curent.next;
        }
        int left = 0, right = builder.length() - 1;
        while (left < right) {
            if (builder.charAt(left++) != builder.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
