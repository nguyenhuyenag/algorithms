package com;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");
        System.out.println(String.join("", stack));
    }

}
