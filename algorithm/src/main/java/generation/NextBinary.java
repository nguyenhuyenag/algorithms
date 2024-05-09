package generation;

public class NextBinary {

	public static String next(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == '0') {
				sb.setCharAt(i, '1');
				for (int j = i + 1; j < sb.length(); j++) {
					sb.setCharAt(j, '0'); // Arrays.fill()
				}
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 4;
		String start = "", end = "";
		for (int i = 0; i < n; i++) {
			start += "0";
			end += "1";
		}
		while (true) {
			String s = next(start);
			System.out.println(s);
			start = s;
			if (s.equals(end)) {
				return;
			}
		}
	}

}
