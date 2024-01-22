package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 *
 * Tìm 3 chữ số giống nhau lớn nhất trong chuỗi chữ số
 *
 * "2300019"       ->      "000"
 * "6777133339"    ->      "777"
 */
public class Largest3SameDigit {

    public boolean allCharactersAreSame(String s, int startIndex, int endIndex) {
        char firstChar = s.charAt(startIndex);
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (firstChar != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String largestGoodInteger(String numStr) {
        int max = -1;
        for (int i = 0; i < numStr.length() - 2; i++) {
            if (allCharactersAreSame(numStr, i, i + 3)) {
                // System.out.println(numStr.substring(i, i + 3));
                max = Math.max(max, Integer.parseInt(numStr.substring(i, i + 3)));
            }
        }
        if (max == -1) return "";
        return max == 0 ? "000" : Integer.toString(max);
    }

    @org.junit.jupiter.api.Test
    public void test() {
        assertEquals("", largestGoodInteger("300"));
        assertEquals("777", largestGoodInteger("6777133339"));
        assertEquals("000", largestGoodInteger("2300019"));
        assertEquals("", largestGoodInteger("101010"));
    }

    //    public String largestGoodInteger_OK(String num) {
//        int max = -1;
//        int len = num.length();
//        for (int i = 0; i <= len - 3; i++) {
//            String t = num.substring(i, i + 3);
//            if (isSameDigit(t)) {
//                max = Math.max(max, Integer.parseInt(t));
//            }
//        }
//        if (max == 0) {
//            return "000";
//        }
//        String smax = String.valueOf(max);
//        return isSameDigit(smax) ? smax : "";
//    }
//
//    public boolean isSameDigit(String numberStr) {
//        char firstDigit = numberStr.charAt(0);
//        for (int i = 1; i < numberStr.length(); i++) {
//            if (firstDigit != numberStr.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public String largestGoodInteger(String numberStr) {
//        String max = "";
//        char[] num = numberStr.toCharArray();
//        for (int i = 2; i < num.length; i++) {
//            if (num[i - 1] == num[i] && num[i] == num[i - 2]) {
//                String str = num[i - 2] + num[i - 1] + num[i] + "";
//                if (Integer.parseInt(str) > Integer.parseInt(max)) {
//                    max = str;
//                }
//            }
//        }
//        return max;
//    }

}
