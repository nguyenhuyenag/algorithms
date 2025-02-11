package array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/find-common-characters/

    Cho mảng chuỗi. Tìm các ký tự chung của các phần tử

        ["bella","label","roller"] -> ["e", "l", "l"]
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        // [{a=1, b=1, e=1, l=2}, {a=1, b=1, e=1, l=2}, {r=2, e=1, l=2, o=1}]
        List<Map<Character, Integer>> counter = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            counter.add(map);
        }

        List<String> result = new ArrayList<>();
        // Phần tử chung sẽ nằm trong chuỗi thứ nhất nên chỉ cần duyệt ở đây là được, không cần a -> z
        Set<Character> firstChars = counter.get(0).keySet();
        for (char c : firstChars) {
            int min = Integer.MAX_VALUE;
            // Kiểm tra c có phải là ký tự chung của mọi phần tử hay không?
            for (Map<Character, Integer> map : counter) {
                if (map.containsKey(c)) { // Có
                    min = Math.min(min, map.get(c));
                } else { // Không
                    min = 0; // Gán min = 0 để vòng lặp phía dưới ko chạy (có thể xem nó là flag = false)
                    break;
                }
            }

            // Lấy kết quả, ví dụ [{a=1, b=2}, {a=2, c=1}] -> {a=1} là phần tử chung
            for (int i = 0; i < min; i++) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertIterableEquals(List.of("e", "l", "l"), commonChars(new String[]{"bella", "label", "roller"}));
        // assertIterableEquals(List.of("c", "o"), commonChars(new String[]{"cool", "lock", "cook"}));
    }

//    /**
//     * Đếm số lần xuất hiện của một ký tự trong chuỗi
//     */
//    public int frequency(String s, char target) {
//        return s.chars().filter(t -> t == target).sum();
//    }
//    public static int demSoLanXuatHien(String chuoi, char kyTu) {
//        int dem = 0;
//        // Duyệt qua từng ký tự trong chuỗi
//        for (int i = 0; i < chuoi.length(); i++) {
//            // Kiểm tra nếu ký tự tại vị trí i là ký tự cần đếm
//            if (chuoi.charAt(i) == kyTu) {
//                dem++;
//            }
//        }
//        return dem;
//    }
//
//    public List<String> commonChars(String[] words) {
//        List<String> commons = new ArrayList<>();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            /**
//             * Đếm số lần xuất hiện của ch trong từng word. Nếu tất cả đều
//             * bằng nhau và = x lần thì thêm x lần ch vào commons
//             */
//            boolean flag = true;
//            Set<Integer> counter = new HashSet<>();
//            for (String word : words) {
//                int count = demSoLanXuatHien(word, ch);
//                if (count == 0) {
//                    flag = false;
//                    break;
//                } else {
//                    counter.add(count);
//                }
//            }
//
//            /**
//             * Sau khi đếm, nếu set chỉ có 1 phần từ -> tất cả đều bằng nhau
//             */
//            if (flag) {
//                // System.out.println(ch + ": " + counter);
//                int min = Collections.min(counter);
//                for (int i = 0; i < min; i++) {
//                    commons.add(String.valueOf(ch));
//                }
//            }
//        }
//        return commons;
//    }
}
