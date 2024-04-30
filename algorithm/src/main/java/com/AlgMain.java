package com;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Stack;

public class AlgMain {

    public void towerHaNoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        if (n == 1) {
            // Move A ---> C: Lấy phần tử tử stack A đẩy vào stack C
            if (!A.isEmpty()) {
                C.push(A.pop());
                System.out.println(A + ", " + B + ", " + C);
            }
        } else {
            // Dùng C là trung gian, dời n - 1 đĩa từ A -> B
            towerHaNoi(n - 1, A, C, B);
            // Dời đĩa lớn nhất từ A -> C
            towerHaNoi(n - 1, A, B, C);
            // Dùng A làm trung gian, dời n - 1 đĩa nhỏ từ B -> C
            towerHaNoi(n - 1, B, A, C);
        }
    }


    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        Collections.addAll(stack, 3, 2, 1);
        System.out.println(stack + ", [], []");
        towerHaNoi(stack.size(), stack, new Stack<>(), new Stack<>());
    }

}
