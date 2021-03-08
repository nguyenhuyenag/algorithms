package com.string;

import java.util.Collections;
import java.util.Map;

// Ký tự xuất hiện nhiều nhất
public class MostChar {

	public static void main(String[] args) {
		String s = "asdadasdsdqweqwewqfwqf";
		Map<Character, Integer> map = CountChar.countCharacter(s);
		System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
	}

}
