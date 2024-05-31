package hashtable;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Đếm số lần xuất hiện của ký tự trong chuỗi
public class Counter {

	public static Map<Character, Long> findTheMostFrequentByMap(String input) {
		Map<Character, Long> map = new HashMap<>();
		for (char key : input.toCharArray()) {
			map.compute(key, (character, count) -> count == null ? 1 : ++count);
		}
		return map;
	}

	public static Map<Character, Long> findTheMostFrequentByMap2(String input) {
		Map<Character, Long> map = new HashMap<>();
		for (char val : input.toCharArray()) {
			map.put(val, map.getOrDefault(val, 0L) + 1);
		}
		return map;
	}

	public static Map<Character, Long> findTheMostFrequentBygroupingBy(String input) {
		return input.chars() //
				.filter(c -> !Character.isWhitespace(c)) // Ignore whitespace
				.mapToObj(c -> (char) c) //
				// .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				.collect(groupingBy(c -> c, counting()));
	}

	public static void findMostCharacter() {
		String input = "aaaaaaaaaabbbbbbbcccccddddeeeff";
		Map<Character, Long> map = findTheMostFrequentByMap(input);
		// Map<Character, Long> map = findTheMostFrequentBygroupingBy(input);
		Entry<Character, Long> maxEntry = Collections.max(map.entrySet(), Entry.comparingByValue());
		Entry<Character, Long> minEntry = Collections.min(map.entrySet(), Entry.comparingByValue());
		System.out.println(map);
		System.out.println("Min: " + minEntry);
		System.out.println("Max: " + maxEntry);
	}

	public static void useSet(String text) {
		String[] arr = text.trim().split("\\s+");
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>(list);
		for (String word : set) {
			// StringUtils.countMatches(text, word);
			System.out.println(word + " => " + Collections.frequency(list, word));
		}
	}

	public static void main(String[] args) {
		findMostCharacter();
	}

}
