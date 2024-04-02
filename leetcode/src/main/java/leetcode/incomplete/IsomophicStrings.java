package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IsomophicStrings {

    public boolean isIsomorphic(String s, String t) {
        // if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new LinkedHashMap<>();
        Map<Character, Integer> map2 = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer v1 = map1.put(s.charAt(i), i);
            Integer v2 = map2.put(t.charAt(i), i);
            // System.out.println(map1 + ", " + map2);
            if (!Objects.equals(v1, v2)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
//        assertEquals(true, isIsomorphic("egg", "add"));
        assertEquals(false, isIsomorphic("foo", "bar"));
//        assertEquals(true, isIsomorphic("paper", "title"));
//        assertEquals(false, isIsomorphic("badc", "baba"));
//        assertEquals(false, isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

}
