package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {

	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

//	public String helper(int n) {
//		StringBuilder sb = new StringBuilder();
//		if (n >= 1_000_000_000) {
//			sb.append(helper(n / 1_000_000_000)).append(" Billion ").append(helper(n % 1_000_000_000));
//		} else if (n >= 1_000_000) {
//			sb.append(helper(n / 1_000_000)).append(" Million ").append(helper(n % 1_000_000));
//		} else if (n >= 1000) {
//			sb.append(helper(n / 1000)).append(" Thousand ").append(helper(n % 1000));
//		} else if (n >= 100) {
//			sb.append(helper(n / 100)).append(" Hundred ").append(helper(n % 100));
//		} else if (n >= 20) {
//			sb.append(tens[n / 10]).append(" ").append(helper(n % 10));
//		} else {
//			sb.append(ones[n]);
//		}
//		return sb.toString().trim();
//	}

	public String helper(int n) {
		StringJoiner sj = new StringJoiner(" ");
		if (n >= 1_000_000_000) {
			sj.add(helper(n / 1_000_000_000)).add("Billion").add(helper(n % 1_000_000_000));
		} else if (n >= 1_000_000) {
			sj.add(helper(n / 1_000_000)).add("Million").add(helper(n % 1_000_000));
		} else if (n >= 1000) {
			sj.add(helper(n / 1000)).add("Thousand").add(helper(n % 1000));
		} else if (n >= 100) {
			sj.add(helper(n / 100)).add("Hundred").add(helper(n % 100));
		} else if (n >= 20) {
			sj.add(tens[n / 10]).add(helper(n % 10));
		} else {
			sj.add(ones[n]);
		}
		return sj.toString().trim();
	}

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		return helper(num).trim();
	}

	@Test
	public void test() {
		String read = numberToWords(142);
		System.out.println("Read = " + read);;
	}

}
