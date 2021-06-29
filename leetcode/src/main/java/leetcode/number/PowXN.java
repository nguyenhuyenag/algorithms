package leetcode.number;

// https://leetcode.com/problems/powx-n
public class PowXN {

	public static double myPow(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	public static double myPow(double x, int n) {
		return myPow(x, n + 0l);
	}

	public static void main(String[] args) {
		System.out.println(myPow(2, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2, -2));
		System.out.println(myPow(2, -2147483648));
	}

}
