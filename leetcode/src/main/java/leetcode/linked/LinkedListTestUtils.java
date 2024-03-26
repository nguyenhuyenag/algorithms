package leetcode.linked;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTestUtils {

    public static void assertLinkedListEquals(ListNode l1, ListNode l2) {
        assertEquals(true, l1.equals(l2));
    }

}
