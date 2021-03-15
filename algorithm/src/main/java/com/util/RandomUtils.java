package com.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
	
	private static int getIntFrom(int min, int max) {
		if (max <= min) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	
	public static int[] randomArrays(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = getIntFrom(-50, 99);
		}
		return array;
	}
	
}
