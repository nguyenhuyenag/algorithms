package dp;

import java.math.BigInteger;

/*
    - Hai tính chất nổi bật của các bài toán QHĐ (dynamic programming)
        + Bài toán có các bài toán con chồng chéo (overlapping subproblems, được gọi đi gọi lại).
        + Bài toán có cấu trúc tối ưu con (optimal substructure).
 */
public class Dynamic {

    /*
        f(0) = 0, f(1) = 1
        If n >= 2: f(n) = f(n - 1) + f(n - 2)
     */
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int[] fib = new int[n + 1];
		fib[0] = 0;
        fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

    public int fibMemory(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int f = a + b;
            a = b;
            b = f;
        }
        return b; // Lúc này là f
    }

//	static void factorial(int n) {
//		int length = n + 1;
//		BigInteger[] arr = new BigInteger[length];
//		arr[0] = BigInteger.ONE; // 0! = 1
//		for (int i = 1; i < length; i++) {
//			arr[i] = BigInteger.valueOf(i).multiply(arr[i - 1]);
//		}
//		System.out.println(n + "! = " + arr[n]);
//	}
//
//	public static BigInteger fibonacci(int n) {
//		BigInteger[] f = new BigInteger[n + 1];
//		f[0] = BigInteger.ZERO;
//		if (n > 0) {
//			f[1] = BigInteger.ONE;
//		}
//		for (int i = 2; i < f.length; i++) {
//			f[i] = f[i - 1].add(f[i - 2]);
//		}
//		return f[n];
//	}
	
}
