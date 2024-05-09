package string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tách ký tự chữ ra khỏi chuỗi
 */
public class SplitCharOutString {

	static public void main(String[] args) {
		String s = "1254abcdd1425";
		Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(s);
		while (matcher.find()) {
			System.out.print(matcher.group());
		}
	}

}
