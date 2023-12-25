package com.recursion;

import java.util.Stack;

public class TowerHaNoi {

    public static void main(String[] args) {
        int numDisks = 3; // You can change the number of disks as needed
        solveTowerOfHanoi(numDisks, "Source", "Auxiliary", "Destination");
    }

    public static void solveTowerOfHanoi(int n, String source, String auxiliary, String destination) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        // Initialize source stack
        for (int i = n; i > 0; i--) {
            stack1.push(i);
        }

        printState(stack1, stack2, stack3);
        moveDisks(n, stack1, stack2, stack3);
    }

    public static void moveDisks(int n, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> destination) {
        if (n > 0) {
            // Move n-1 disks from source to auxiliary using destination as auxiliary
            moveDisks(n - 1, source, destination, auxiliary);

            // Move the nth disk from source to destination
            destination.push(source.pop());
            printState(source, auxiliary, destination);

            // Move the n-1 disks from auxiliary to destination using source as auxiliary
            moveDisks(n - 1, auxiliary, source, destination);
        }
    }

    public static void printState(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        System.out.println(A + ", " + B + ", " + C);
    }

//    public static void hanoi(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
//        // Trường hợp cơ bản
//        if (n == 1) {
//            c.push(a.pop());
//        } else {
//            // Di chuyển n-1 đĩa từ cột 1 sang cột 2
//            hanoi(n - 1, a, c, b);
//            // In ra trạng thái
//            System.out.println(a + ", " + b + ", " + c);
//            // Di chuyển đĩa lớn nhất từ cột 1 sang cột 3
//            c.push(a.pop());
//            // In ra trạng thái
//            System.out.println(a + ", " + b + ", " + c);
//            // Di chuyển n-1 đĩa từ cột 2 sang cột 3
//            hanoi(n - 1, b, a, c);
//            System.out.println(a + ", " + b + ", " + c);
//        }
//    }
//
//    public static void main(String[] args) {
//        // Tạo các cột
//        Stack<Integer> a = new Stack<>();
//        Stack<Integer> b = new Stack<>();
//        Stack<Integer> c = new Stack<>();
//
//        // Thêm các đĩa vào cột 1
//        for (int i = 3; i >= 1; i--) {
//            a.push(i);
//        }
//        System.out.println(a + ", " + b + ", " + c);
//        // Giải bài toán
//        hanoi(3, a, b, c);
////        System.out.println(a + ", " + b + ", " + c);
//    }

    //    public static void main(String[] args) {
//        int n = 3; // Số đĩa
//
//        // Khởi tạo ba stack để biểu diễn ba cột A, B, C
//        Stack<String> towerA = new Stack<>();
//        Stack<String> towerB = new Stack<>();
//        Stack<String> towerC = new Stack<>();
//
//        // Khởi tạo tháp A với n đĩa
//        for (int i = n; i > 0; i--) {
//            towerA.push(String.valueOf(i));
//        }
//
//        // In trạng thái ban đầu của tháp
//        printTowers(towerA, towerB, towerC);
//
//        // Gọi hàm đệ quy để giải bài toán
//        move(n, towerA, towerB, towerC);
//
//        // In trạng thái cuối cùng của tháp
//        // printTowers(towerA, towerB, towerC);
//    }
//
//    // Hàm đệ quy giải bài toán tháp Hà Nội
//    private static void move(int n, Stack<String> source, Stack<String> auxiliary, Stack<String> target) {
//        if (n > 0) {
//            // Di chuyển n-1 đĩa từ nguồn đến trung gian
//            move(n - 1, source, target, auxiliary);
//
//            // Di chuyển đĩa cuối cùng từ nguồn đến đích
//            target.push(source.pop());
//
//            // In trạng thái hiện tại của tháp
//            printTowers(source, auxiliary, target);
//
//            // Di chuyển n-1 đĩa từ trung gian đến đích
//            move(n - 1, auxiliary, source, target);
//        }
//    }
//
//    // Hàm in trạng thái của ba tháp
//    public static void printTowers(Stack<String> towerA, Stack<String> towerB, Stack<String> towerC) {
//        System.out.println("[" + join(towerA) + ", " + join(towerB) + ", " + join(towerC) + "]");
//    }
//
    public static String join(Stack<String> tower) {
        return tower.isEmpty() ? "_" : String.join("", tower);
    }

}
