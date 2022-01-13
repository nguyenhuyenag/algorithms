package com.util;

import java.util.Arrays;
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
			array[i] = getIntFrom(-10, 20);
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	public static void main(String[] args) {
		randomArrays(5);
	}

}
