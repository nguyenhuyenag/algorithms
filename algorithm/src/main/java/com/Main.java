package com;

import java.util.Arrays;

import com.util.RandomUtils;

public class Main {
	
	// Dịch sang trái 2 bước các phần tử khác A
	public static void move() {
		// số bước dịch chuyển
		final int STEP_MOVE = 2;
		// chuỗi thực tế cần dịch chuyển
		StringBuilder sb = new StringBuilder();
		char arr[] = { 'A', 'B', 'C', 'D', 'A', 'A', 'E' };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 'A') {
				sb.append(arr[i]);
			}
		}
		int len = sb.length() - 1;
		// ở mỗi bước ta dời phần tử cuối lên đầu
		for (int i = 0; i < STEP_MOVE; i++) {
			char last = sb.charAt(len);
			sb.deleteCharAt(len);
			sb.insert(0, last);
		}
		// chèn lại các vị trí của A
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'A') {
				sb.insert(i, "A");
			}
		}
		System.out.println(Arrays.toString(sb.toString().split("")));
	}

	public static int binarySearch(int[] A, int key) {
		int l = 0;
		int r = A.length - 1;
		while (r - l >= 0) {
			int m1 = l + (r - l) / 3;
			int m2 = r - (r - l) / 3;
			if (A[m1] == key) {
				return m1;
			}
			if (A[m2] == key) {
				return m2;
			}
			if (A[m1] > key) {
				r = m1 - 1;
			} else if (A[m2] < key) {
				l = m2 + 1;
			} else {
				l = m1 + 1;
				r = m2 - 1;
			}
		} // while ends
		return -1;
	}

	public static void main(String[] args) {
		int[] A = RandomUtils.randomArrays(10);
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println(binarySearch(A, A[4]));
	}

}
