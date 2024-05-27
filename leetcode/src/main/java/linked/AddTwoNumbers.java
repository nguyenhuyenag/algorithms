package linked;

import org.junit.jupiter.api.Test;
import util.LinkedListTestUtils;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/*
    https://leetcode.com/problems/add-two-numbers/

    Cộng 2 danh sách liên kết đại diện cho 2 số nguyên (từ phải sang trái).

    Ví dụ: 342 + 465 = 807

        2  4  3
        5  6  4
       ---------
        7  0  8
 */
public class AddTwoNumbers {

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

    @Test
    public void test1() {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(7, 0, 8), addTwoNumbers(l1, l2));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.of(0);
        ListNode l2 = ListNode.of(0);
        LinkedListTestUtils.assertLinkedListEquals(ListNode.of(0), addTwoNumbers(l1, l2));
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

}
