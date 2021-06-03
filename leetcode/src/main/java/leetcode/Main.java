package leetcode;

import java.util.Arrays;

public class Main {
	
	public int[] plusOne(int[] digits) {
		int ONE = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
        	digits[i] += ONE;
        	if (digits[i] <= 9) {
        		return digits;
        	}
        	digits[i] = 1;
        }
        return digits;
    }

	public static void main(String[] args) {
		
	}

}
