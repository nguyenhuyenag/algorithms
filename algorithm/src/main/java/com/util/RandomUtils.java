package com.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

	public static int getIntFrom(int min, int max) {
		if (max <= min) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public static int getInt() {
		return getIntFrom(-99, 99);
	}

	public static int[] randomArrays(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = getIntFrom(-20, 20);
		}
		System.out.println("Array: " + Arrays.toString(array));
		return array;
	}

	public static void main(String[] args) {
		randomArrays(5);
	}

}
