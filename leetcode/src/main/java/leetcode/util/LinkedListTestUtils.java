package leetcode.util;

import leetcode.linked.ListNode;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTestUtils {

    public static void assertLinkedListEquals(ListNode l1, ListNode l2) {
        assertTrue(l1.equals(l2));
    }

}
