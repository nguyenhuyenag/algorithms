//package util;
//
//public class FindMaxWithoutLoop {
//
//	public static int findMaxWithoutLoop(int[] A, int len) {
//		if (len == 0) {
//			return A[0];
//		}
//		int max = A[len - 1];
//		return Math.max(max, findMaxWithoutLoop(A, len - 1));
//	}
//
//	public static void main(String[] args) {
//		int[] arr = RandomUtils.randomArray();
//		System.out.println(findMaxWithoutLoop(arr, arr.length));
//	}
//
//}
