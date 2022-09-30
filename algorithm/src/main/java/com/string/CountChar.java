package com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Đếm số lần xuất hiện của ký tự trong chuỗi
public class CountChar {

	public static Map<Character, Integer> countCharacter(String str) {
		char[] arr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char key : arr) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		return map;
	}
	
	public static void groupingBy() {
		List<String> wordsList = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");
		Map<String, Long> collect = wordsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect.toString());
	}

	public static void main(String[] args) {
		String str = "asdadasdsdqweqwewqfwqf";
		countCharacter(str).forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
