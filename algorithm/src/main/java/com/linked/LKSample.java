package com.linked;

import java.util.List;

public class LKSample {

    /**
     * Nhập các giá trị ngẫu nhiên và LK
     */
    public static ListNode create() {
        ListNode listNode = null; // Tạo danh sách (head)
        ListNode current = null; // Con trỏ
        for (int val : List.of(2, 1, 7, 9, 0)) {
            ListNode newNode = new ListNode(val);
            if (listNode == null) {
                listNode = newNode; // Nếu listNode rỗng thì node mới là node tầu tiên
            } else {
                current.next = newNode; // Ngược lại, liên kết node hiện tại với node mới
            }
            current = newNode; // Dời con trỏ đến node mới
        }
        return listNode;
    }

    public static ListNode create2() {
        ListNode head = new ListNode(1); // ListNode() -> 0 là giá trị mặc định
        for (int v : List.of(2, 3, 4, 5)) {
            head.add(v);
        }
        return head;
    }

//    /**
//     * Duyệt danh sách liên kết
//     */
//    public static void printLinkedList(ListNode head) {
//        StringJoiner joiner = new StringJoiner(", ", "[", "]");
//        ListNode curent = head;
//        while (curent != null) {
//            joiner.add(String.valueOf(curent.val));
//            curent = curent.next; // Di chuyển con trỏ
//        }
//        System.out.println(joiner.toString());
//    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next; // Lưu node tiếp theo trước khi di chuyển
            current.next = prev; // Đảo ngược con trỏ

            // Di chuyển pre, current đến vị trí tiếp theo trong danh sách
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = create2();
//        listNode.addFirst(100);
        listNode.showList();
        // listNode = reverseList(listNode);
        // printLinkedList(listNode);
    }

}
