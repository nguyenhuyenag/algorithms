package com.stack;

import lombok.NoArgsConstructor;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackSample {

    @NoArgsConstructor
    private static class MyStack {

        private final int MAX_SIZE = 1_000_000;
        private final int[] stack = new int[MAX_SIZE];
        private int top = 0;

        public void push(int x) {
            if (top < MAX_SIZE) {
                stack[top++] = x;
            } else {
                throw new StackOverflowError("Stack is full"); // Handle stack overflow
            }
        }

        public int pop() {
            if (top > 0) {
                return stack[--top];
            }
            throw new EmptyStackException();
        }

        public int peek() {
            if (top > 0) {
                return stack[top - 1];
            }
            throw new EmptyStackException();
        }

        public boolean isEmpty() {
            return top == 0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
