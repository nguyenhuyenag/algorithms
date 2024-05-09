package string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Chủ đề: Mảng đánh dấu
 *
 * https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/
 *
 * Có bao nhiêu ký tự (không phân biệt hoa thường) xuất hiện nhiều hơn 1 lần trong chuỗi?
 */
public class CoutingDuplicates {

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

    /**
     * Nếu currentChar là ký tự 'a', giá trị ASCII của 'a' là 97. Do đó, charCount[97] sẽ được tăng lên 1.
     *
     * Nếu currentChar là ký tự 'A', giá trị ASCII của 'A' là 65. Do đó, charCount[65] sẽ được tăng lên 1.
     */
    public int duplicateCount(String text) {
        int count = 0;
        int[] charCount = new int[256]; // Sử dụng mảng để đếm tần suất xuất hiện của các ký tự ASCII
        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            charCount[c]++;
        }
        for (int val : charCount) {
            if (val > 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(0, duplicateCount("abcde"));
        assertEquals(1, duplicateCount("abcdea"));
        assertEquals(1, duplicateCount("indivisibility"));
        assertEquals(26, duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
    }

}
