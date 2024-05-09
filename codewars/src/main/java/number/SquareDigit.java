package number;

// Bình phương từng chữ số
public class SquareDigit {

//	public static int squareDigits0(int n) {
//		String s = "";
//		while (n > 0) {
//			int last = n % 10;
//			s = last * last + s;
//			n /= 10;
//		}
//		return Integer.parseInt(s);
//	}

	public static int squareDigits(int n) {
		StringBuilder ans = new StringBuilder();
		while (n > 0) {
			int last = n % 10;
			n /= 10;
			ans.insert(0, last * last);
		}
		return Integer.parseInt(ans.toString());
	}

	public static void main(String[] args) {
		System.out.println(squareDigits(9119));
	}

}
