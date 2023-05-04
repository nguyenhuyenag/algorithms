package com.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitNumber {

	public static void main(String[] args) {
		int number = 58;
		int n = number;
		List<Integer> setOfNumbers = Arrays.asList(1, 14, 16, 18, 19);
		List<String> result = new ArrayList<>();
		Collections.sort(setOfNumbers, Collections.reverseOrder()); // Sắp xếp tập hợp theo thứ tự giảm dần
		for (int num : setOfNumbers) {
			while (n >= num) {
				result.add(String.valueOf(num));
				n -= num;
			}
		}
		if (n == 0) {
			System.out.println(number + " = " + String.join(" + ", result));
		} else {
			System.out.println("No solution!");
		}
	}

}
