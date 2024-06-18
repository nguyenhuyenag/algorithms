package recursion.backtracking;

import java.io.IOException;

/*-
 *	n = 5
 * 		1 1 1 1 1
 * 		1 1 1 2
 * 		1 1 3
 * 		1 2 2
 * 		1 4
 * 		2 3
 * 		5
 */
public class ChiaNhoSo {

	static void find(int n, int[] X, int[] arr, int i) {
		int j, k;
		for (j = X[i - 1]; j <= (n - arr[i - 1]); j++) {
			X[i] = j;
			arr[i] = arr[i - 1] + j;
			if (arr[i] == n) {
				for (k = 1; k <= i; k++) {
					System.out.print(X[k] + " ");
				}
				System.out.println();
			} else {
				find(n, X, arr, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int n = 5;
		int[] X = new int[n + 1];
		int[] T = new int[n + 1];
		X[0] = 1;
		T[0] = 0;
		find(n, X, T, 1); // Mảng nghiệm tính từ i = 1
	}

}
