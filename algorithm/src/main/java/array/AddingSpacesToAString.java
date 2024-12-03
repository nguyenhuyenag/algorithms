package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/adding-spaces-to-a-string/

    Cho chuỗi s và mảng số nguyên spaces chứa vị trị sẽ thêm khoảng trắng vào chuỗi s.

    Trả về chuỗi s sao khi thêm vào khoảng trắng.
 */
public class AddingSpacesToAString {

    public String addSpaces(String s, int[] spaces) {
        int j = 0;
        int lengthSpaces = spaces.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (j < lengthSpaces && i == spaces[j]) {
                builder.append(" ");
                j++;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    @Test
    public void test() {
        assertEquals("i code in py thon", addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
        assertEquals("Leetcode Helps Me Learn", addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

}
