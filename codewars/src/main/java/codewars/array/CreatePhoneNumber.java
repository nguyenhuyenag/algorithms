package codewars.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * Chủ đề: String format
 * 
 * https://www.codewars.com/kata/525f50e3b73515a6db000b83/
 */
public class CreatePhoneNumber {

	public static String createPhoneNumber0(int[] numbers) {
		StringBuilder ans = new StringBuilder();
		for (int x : numbers) {
			ans.append(x);
			if (ans.length() == 3) {
				ans.insert(0, "(");
				ans.append(") ");
			}
		}
		ans.insert(9, "-");
		return ans.toString();
	}

	public static String createPhoneNumber1(int[] numbers) {
		// Arrays.stream(numbers).boxed().toArray(Integer[]::new)
		return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
	}

	public static String createPhoneNumber(int[] numbers) {
		String phone = new String("(xxx) xxx-xxxx");
		for (int i : numbers) {
			phone = phone.replaceFirst("x", Integer.toString(i));
		}
		return phone;
	}

	@Test
	public void testSomething() {
		assertEquals("(123) 456-7890", createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
	}

}
