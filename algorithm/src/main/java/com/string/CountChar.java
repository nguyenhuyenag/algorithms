package com.string;

import java.util.HashMap;
import java.util.Map;

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

	public static void main(String[] args) {
		String str = "asdadasdsdqweqwewqfwqf";
		countCharacter(str).forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
