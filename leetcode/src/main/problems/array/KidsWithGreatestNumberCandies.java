package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithGreatestNumberCandies {

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
		int max = Arrays.stream(candies).max().getAsInt();
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}
