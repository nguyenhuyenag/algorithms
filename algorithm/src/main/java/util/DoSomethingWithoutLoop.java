package util;

public class DoSomethingWithoutLoop {

//	public static void rotate(int[] A, int n) {
//		if (n >= 0) {
//			System.out.println(A[n]);
//			rotate(A, n - 1);
//		}
//	}

    public static int findMaxWithoutLoop(int[] A, int len) {
        if (len == 0) {
            return A[0];
        }
        int max = A[len - 1];
        return Math.max(max, findMaxWithoutLoop(A, len - 1));
    }

    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4, 5};
//        rotate(A, A.length - 1);
//        System.out.println("A = " + Arrays.toString(A));

        // findMaxWithoutLoop
        int[] arr = RandomUtils.randomArray();
        System.out.println(findMaxWithoutLoop(arr, arr.length));
    }

}
