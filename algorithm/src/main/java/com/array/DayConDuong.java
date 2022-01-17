package com.array;

import java.util.Scanner;

import com.util.RandomUtils;

/*-
 * - Tìm dãy con toàn dương dài nhất trong mảng
 * 
 * - Gọi max là chiều dài dãy con dương dài nhất, cmax là chiều dài dãy con dương hiện tại.
 * 
 * - Duyệt mảng, với mỗi phần tử x ​​ta kiểm tra, nếu x > 0 thì tăng cmax lên 1 đơn vị, ngược lại thì ta gán max = MAX(max, cmax), đồng
 * thời đặt cmax = 0.
 * 
 * - KQ: MAX(max, cmax)
 * 
 */
public class DayConDuong {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			// int n = io.nextInt();
			// int[] arr = new int[n];
//			for (int i = 0; i < n; i++) {
//				// arr[i] = io.nextInt();
//			}
			int[] arr = RandomUtils.randomArrays(15);
			int max = 0, cmax = 0;
			for (int x : arr) {
				if (x > 0) {
					cmax++;
				} else {
					max = Math.max(max, cmax);
					cmax = 0;
				}
			}
			System.out.println(Math.max(max, cmax));
		}
	}

}
