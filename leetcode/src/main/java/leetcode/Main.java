package leetcode;

/*-
 * https://leetcode.com/problems/decoded-string-at-index/description/
 *
 * Cho chuỗi s và số nguyên k, thực hiện mã hóa chuỗi theo tiêu chí
 *    
 *    + Nếu ký tự nhập vào là chữ thì giữ nguyên
 *    
 *    + Nếu ký tự nhập vào là số d, lặp lại chuỗi mã hóa hiện tại d - 1 lần
 * 
 * Trả về ký tự vị trí thứ k (tính từ 1) của chuỗi mã hóa
 */
public class Main {

	public StringBuilder repeatedString(StringBuilder originalString, int repeatCount) {
		StringBuilder repeatedString = new StringBuilder();
		for (int i = 0; i < repeatCount; i++) {
			repeatedString.append(originalString);
		}
		return repeatedString;
	}

	public String decodeAtIndex(String s, int k) {
		StringBuilder ans = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isLetter(c)) {
				ans.append(c);
			}
			if (Character.isDigit(c)) {
				ans = repeatedString(ans, Character.getNumericValue(c));
			}
		}
		System.out.println(ans);
		return Character.toString(ans.charAt(k + 1));
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.decodeAtIndex("ha22", 5); // h
		m.decodeAtIndex("leet2code3", 10); // o
		// m.decodeAtIndex("a2345678999999999999999", 1); // a
	}

}
