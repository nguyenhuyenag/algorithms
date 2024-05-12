package map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/isomorphic-strings/

    Xác định 2 chuỗi đồng dạng.
 */
public class IsomophicStrings {

    public boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> map1 = new LinkedHashMap<>();
        Map<Character, Integer> map2 = new LinkedHashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            // put() -> Nếu chưa có thì thêm mới và trả về null, ngược lại sẽ cập nhật và trả vể giá trị cũ
            Integer val1 = map1.put(s1.charAt(i), i);
            Integer val2 = map2.put(s2.charAt(i), i);
            System.out.println(val1 + ", " + val2);
            if (!Objects.equals(val1, val2)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        // assertEquals(true, isIsomorphic("egg", "add"));
        // assertEquals(false, isIsomorphic("foo", "bar"));
        // assertEquals(true, isIsomorphic("paper", "title"));
        assertEquals(false, isIsomorphic("badc", "baba"));
        // assertEquals(false, isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

}
