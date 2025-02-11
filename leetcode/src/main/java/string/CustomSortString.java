package string;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/custom-sort-string/

    Cho 2 chuỗi s1 (các ký tự là duy nhất) và s2. Sắp xếp lại s2 theo thứ tự các ký tự trong s1

        s1 = "cba",   s2 = "abcd"  ->  "cbad"

        s1 = "bcafg", s2 = "abcd"  ->  "bcad"

    Xem thêm: leetcode > RelativeSortArray.java
 */
public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> iMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            iMap.put(order.charAt(i), i);
        }

        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }

        // So sánh theo index trong order, nếu không tồn tại gán cho MAX_VALUE để đẩy nó về cuối
        result.sort(Comparator.comparingInt(c -> iMap.getOrDefault(c, Integer.MAX_VALUE)));

        StringBuilder builder = new StringBuilder();
        result.forEach(builder::append);
        return builder.toString();
    }

    @Test
    public void test() {
        assertEquals("cbad", customSortString("cba", "abcd"));
        assertEquals("bcad", customSortString("bcafg", "abcd"));
    }

}
