package com;

import java.util.Stack;

public class AlgMain {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");
        System.out.println(String.join("", stack));
    }

}
