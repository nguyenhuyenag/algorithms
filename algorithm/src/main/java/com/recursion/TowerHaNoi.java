package com.recursion;

import java.util.Stack;

public class TowerHaNoi {

    public static void main(String[] args) {
        int n = 3;
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> C = new Stack<>();
        for (int i = n; i > 0; i--) {
            A.push(i);
        }
        printState(A, B, C);
        move(n, A, B, C);
    }

    public static void move(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        if (n > 0) {
            move(n - 1, A, C, B);
            C.push(A.pop());
            printState(A, B, C);
            move(n - 1, B, A, C);
        }
    }

    public static void printState(Stack<?> A, Stack<?> B, Stack<?> C) {
        System.out.println(A + ", " + B + ", " + C);
    }

}
