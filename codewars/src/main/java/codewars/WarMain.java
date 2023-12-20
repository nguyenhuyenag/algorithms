package codewars;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/
 */
public class WarMain {

    public static int duplicateCount(String text) {
        int count = 0;
//        int[] visited = new int[26 * 2]; // 26 chữ thường + 26 chữ hoa
//        for (char c : text.toCharArray()) {
//            if (Character.isLetter(c)) {
//                // Chuyển đổi chữ cái thành số index trong bảng chữ cái
//                int index;
//                if (Character.isLowerCase(c)) {
//                    index = c - 'a';
//                } else {
//                    index = c - 'A' + 26;  // Chữ hoa nằm sau chữ thường
//                }
//                visited[index]++;
//            }
//        }
//        for (int i = 0; i < visited.length; i++) {
//            if (visited[i] > 1) {
//                count++;
//            }
//        }
//        System.out.println(Arrays.toString(visited));

        // Cach 2
//        Map<Character, Integer> charCount = new HashMap<>();
//        for (char c : text.toCharArray()) {
//            if (Character.isLetter(c)) {
//                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
//            }
//        }
//        for (Map.Entry<Character, Integer> e : charCount.entrySet()) {
//            if (e.getValue() > 1) {
//                count++;
//            }
//        }
//        System.out.println(charCount);
//        System.out.println(count);

        // Cach 3
        // input = input.toLowerCase(); // Chuyển đổi chuỗi thành chữ thường để không phân biệt chữ hoa và chữ thường
        int[] charCount = new int[256]; // Sử dụng mảng để đếm tần suất xuất hiện của các ký tự ASCII

        for (char c : text.toLowerCase().toCharArray()) {
            charCount[c]++;
        }

        // int duplicateCount = 0;
        for (int c : charCount) {
            if (c > 1) {
                count++;
            }
        }

        return count;
    }

    @Test
    public void abcdeReturnsZero() {
//         assertEquals(0, duplicateCount("abcde"));
//         assertEquals(1, duplicateCount("abcdea"));
//         assertEquals(1, duplicateCount("indivisibility"));
//        assertEquals(26, duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
        duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix");
    }

}
