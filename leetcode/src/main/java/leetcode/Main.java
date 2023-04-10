package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class Main {

	// '(', ')', '{', '}', '[', ']'
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else {
				if (stack.isEmpty() || stack.pop() != c) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "()";
		isValid(s);
	}

	@Test
	public void test() {
		String s = "()";
		assertEquals(true, isValid(s));
	}

}
