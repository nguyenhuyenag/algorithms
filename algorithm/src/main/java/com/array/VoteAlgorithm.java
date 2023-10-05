package com.array;

public class VoteAlgorithm {

	public static int majorityElement(int[] nums) {
		int candidate = nums[0]; // Giả sử phần tử đầu tiên là ứng cử viên
		int count = 1; // Số lần xuất hiện của ứng cử viên

		// Lặp qua mảng từ phần tử thứ 2 trở đi
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == candidate) {
				// Nếu phần tử hiện tại giống ứng cử viên, tăng biến đếm
				count++;
			} else {
				// Nếu phần tử hiện tại khác ứng cử viên, giảm biến đếm
				count--;
				// Nếu biến đếm giảm xuống 0, chọn phần tử hiện tại làm ứng cử viên mới
				if (count == 0) {
					candidate = nums[i];
					count = 1;
				}
			}
		}

		// Sau khi lặp xong, candidate chính là phần tử xuất hiện nhiều hơn
		// Kiểm tra xem candidate có thực sự là phần tử xuất hiện nhiều hơn nữa
		int candidateCount = 0;
		for (int num : nums) {
			if (num == candidate) {
				candidateCount++;
			}
		}
		System.out.println("Count:" + candidateCount);
		return candidate;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 4, 5, 4, 4, 4 };
		System.out.println(majorityElement(nums));
	}

}
