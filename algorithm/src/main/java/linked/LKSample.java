package linked;

import java.util.List;

public class LKSample {

//    /**
//     * Nhập các giá trị ngẫu nhiên và LK
//     */
//    public static ListNode create() {
//        ListNode listNode = null; // Tạo danh sách (head)
//        ListNode current = null; // Con trỏ
//        for (int val : List.of(2, 1, 7, 9, 0)) {
//            ListNode newNode = new ListNode(val);
//            if (listNode == null) {
//                listNode = newNode; // Nếu listNode rỗng thì node mới là node tầu tiên
//            } else {
//                current.next = newNode; // Ngược lại, liên kết node hiện tại với node mới
//            }
//            current = newNode; // Dời con trỏ đến node mới
//        }
//        return listNode;
//    }

    public static ListNode create2() {
        ListNode head = new ListNode(1); // ListNode() -> 0 là giá trị mặc định
        for (int v : List.of(2, 3, 4, 5)) {
            head.addLast(v);
        }
        return head;
    }

    public static void testAddFirst() {
        ListNode head = ListNode.of(0, 1, 2, 3, 4);
        // head = head.addFirst(-1);
        head.addFirst(1_000);
        // head.addFirst(2_000);
        // head.addFirst(3_000);
        head.showList();
    }

    public static void testInsert() {
        ListNode head = ListNode.of(0, 1, 2, 3, 4);
        System.out.println("size = " + head.size());
        head.insert(7, 100);
        head.showList();
    }

    public static void testReverse() {
        ListNode head = ListNode.of(0, 1, 2, 3, 4);
        head = head.reverse();
        head.showList();
    }

    public static void testIndexOf() {
        ListNode head = ListNode.of(0, 1, 2, 3, 4);
        int idx = head.indexOf(3);
        System.out.println("idx = " + idx);
    }

    public static void testRemove() {
        ListNode head = ListNode.of(0, 1, 2, 3, 4);
        // head = head.remove(0);
        head = head.deleteNode(3);
        head.showList();
    }

    public static void main(String[] args) {
        // ListNode listNode = create2();
        // listNode = reverseList(listNode);
        // printLinkedList(listNode);
        // listNode.showList();
         testAddFirst();
        // testInsert();
        // testReverse();
        // testIndexOf();
        // testRemove();
    }


}
