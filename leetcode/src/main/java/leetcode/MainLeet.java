package leetcode;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainLeet {

    @Test
    public void test() {
        Stack<Character> stack = new Stack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.forEach(System.out::println);
        Collections.reverse(stack);
        stack.forEach(System.out::println);
    }

}
