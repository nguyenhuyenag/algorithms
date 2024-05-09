package array;

public class VoteAlgorithm {

	public static int majorityElement(int[] nums) {
		int key = nums[0]; 	// Chọn phần từ đầu tiên ứng cử viên
		int count = 1; 		// Số lần xuất hiện của ứng cử viên

		// Lặp qua mảng từ phần tử thứ 2 trở đi
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == key) {
				// Nếu phần tử hiện tại giống ứng cử viên, tăng biến đếm
				count++;
			} else {
				// Nếu khác ứng cử viên thì giảm biến đếm
				count--;
				// Nếu biến đếm giảm xuống 0, chọn phần tử hiện tại làm ứng cử viên mới
				if (count == 0) {
					key = nums[i];
					count = 1;
				}
			}
		}

		// Sau khi lặp xong, key chính là phần tử xuất hiện nhiều hơn
		// Kiểm tra xem key có thực sự là phần tử xuất hiện nhiều hơn nữa
		int keyCount = 0;
		for (int num : nums) {
			if (num == key) {
				keyCount++;
			}
		}
		System.out.println("Count:" + keyCount);
		return key;
	}

	public static void main(String[] args) {
		int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int result = majorityElement(nums);
		System.out.println("Majority Element: " + result);
	}

}
