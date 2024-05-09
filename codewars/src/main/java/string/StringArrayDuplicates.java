package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/59f08f89a5e129c543000069/
 *
 * Xóa ký tự trùng liên tiếp trong chuỗi:
 *
 *      kelless -> keles
 *      keenness -> kenes
 */
public class StringArrayDuplicates {

    /**
     * Lặp từng ký tự và chèn vào builder, nếu ký tự hiện tại khác
     * với ký tự trong builder thì mới add
     */
    public static String removeDuplicate(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (builder.isEmpty() || c != builder.charAt(builder.length() - 1)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static String[] dup(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = removeDuplicate(arr[i]);
        }
        return arr;
    }

    @Test
    public void test() {
        String[] arr = {"abracadabra", "allottee", "assessee"};
        assertArrayEquals(arr, dup(arr));
    }

}
