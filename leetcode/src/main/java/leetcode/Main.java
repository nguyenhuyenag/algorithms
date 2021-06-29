package leetcode;

// https://leetcode.com/problems/powx-n
public class Main {

	public static double cal(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? cal(x * x, n / 2) : x * cal(x * x, n / 2);
	}

	public static double myPow(double x, int n) {
		return cal(x, n + 0l);
	}

	public static void main(String[] args) {
		System.out.println(myPow(2, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2, -2));
		System.out.println(myPow(2, -2147483648));
	}

}
