package number;

/**
 * Kiểm tra các chữ số tăng dần
 *
 * Xem thêm TidyNumber.java
 */
public class ChuSoTangDan {

	public static boolean isMonotonic(int n) {
		int prevDigit = n % 10;
		n /= 10;
		while (n > 0) {
			int currentDigit = n % 10;
			n /= 10;
			if (currentDigit >= prevDigit) {
				// System.out.println("NO");
				return false;
			}
			prevDigit = currentDigit;
		}
		// System.out.println("YES");
		return true;
	}

	public static void main(String[] args) {
		int n = 123450;
		System.out.println("Check: " + isMonotonic(n));
	}


}
