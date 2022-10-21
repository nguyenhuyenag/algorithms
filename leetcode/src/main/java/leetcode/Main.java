package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/problems/powx-n
public class Main {

	public static double cal(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? cal(x * x, n / 2) : x * cal(x * x, n / 2);
	}

	public static double myPow(double x, int n) {
		return cal(x, n + 0l);
	}

	public static boolean checkIfPangram(String str) {
		int[] marks = new int[25];
		for (int i = 0; i < str.length(); i++) {

		}
		return true;
	}

	// a - z: 26 ký tự
	public static void main(String[] args) {
		String[] arr = {"the","day","is","sunny","the","the","the","sunny","is","is"};
		Map<String, Long> group = Arrays.stream(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(group);
		group.entrySet().stream() //
				// .sorted(Map.Entry.comparingByValue()) //
				.sorted(Comparator.comparing(Map.Entry::getValue)) //
				.forEach(t -> System.out.println(t));
	}

}
