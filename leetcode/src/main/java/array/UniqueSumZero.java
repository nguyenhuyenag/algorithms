package array;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 *
 * Tạo mảng n số nguyên khác nhau có tổng  = 0
 *
 * Gán n - 1 số (>=0) đầu tiên là sum, gán số cuối cùng -sum
 */
public class UniqueSumZero {

	public static int[] sumZero(int n) {
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i;
			sum += i;
		}
		arr[n - 1] = -sum;
		return arr;
	}

}
