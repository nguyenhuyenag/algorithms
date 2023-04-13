package leetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValiParentheses {

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
	public void test1() {
		String s = "()";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test2() {
		String s = "()[]{}";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test3() {
		String s = "(]";
		assertEquals(false, isValid(s));
	}

}
