package number;

import java.util.ArrayList;
import java.util.List;

public class SplitNumber {

	public static List<Integer> chiaSo(int number, int[] setOfNumbers) {
		List<Integer> result = null;
		if (number == 0) {
			result = new ArrayList<>();
		} else {
			for (int num : setOfNumbers) {
				if (num <= number) {
					List<Integer> subResult = chiaSo(number - num, setOfNumbers);
					if (subResult != null) {
						subResult.add(num);
						if (result == null || subResult.size() < result.size()) {
							result = subResult;
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int number = 8;
		int[] setOfNumbers = { 3, 5, 7 };
		List<Integer> result = chiaSo(number, setOfNumbers);
		if (!result.isEmpty()) {
			System.out.println(result);
		} else {
			System.out.println("No solution!");
		}
	}

}
