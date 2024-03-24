package leetcode.linked;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static leetcode.linked.ListNode.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {


//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int rem = 0;
//        StringBuilder result = new StringBuilder();
//        while (l1 != null || l2 != null || rem != 0) {
//            int digit1 = l1 != null ? l1.val : 0;
//            int digit2 = l2 != null ? l2.val : 0;
//
//            int sum = digit1 + digit2 + rem;
//            result.append(sum % 10);
//            rem = sum / 10;
//
//            l1 = l1 != null ? l1.next : null;
//            l2 = l2 != null ? l2.next : null;
//        }
//
//        ListNode head = null;
//        ListNode current = null;
//        for (int i = 0; i < result.length(); i++) {
//            ListNode newNode = new ListNode(Character.getNumericValue(result.charAt(i)));
//            if (head == null) {
//                head = newNode;
//            } else {
//                current.next = newNode;
//            }
//            current = newNode;
//        }
//        return head;
//    }

    /**
     * Tạo ListNode có 1 giá trị, kết quả trả về là result.next
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return head.next; // Bỏ nút đầu tiên
    }

    /**
     * Không cần giá trị mặc định
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = null;
//        ListNode current = null;
//        int carry = 0;
//
//        while (l1 != null || l2 != null) {
//            int digit1 = l1 != null ? l1.val : 0;
//            int digit2 = l2 != null ? l2.val : 0;
//
//            int sum = digit1 + digit2 + carry;
//            int val = sum % 10;
//            carry = sum / 10;
//
//            ListNode nextNode = new ListNode(val);
//            if (result == null) {
//                result = nextNode;
//            } else {
//                current.next = nextNode;
//            }
//
//            current = nextNode;
//
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//
//            result.showList();
//        }
//
//        if (carry > 0) {
//            current.next = new ListNode(carry);
//        }
//
//        return result; // .next; // Bỏ nút đầu tiên
//    }


    /**
     * Create Data & Test
     */
    public List<Integer> call(int[] val1, int[] val2) {
        ListNode l1 = of(val1);
        ListNode l2 = of(val2);
        ListNode listNode = addTwoNumbers(l1, l2);
        return listNode.toList();
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(7, 0, 8), call(new int[]{2, 4, 3}, new int[]{5, 6, 4}));
        assertIterableEquals(List.of(0), call(new int[]{0}, new int[]{0}));
    }

}
