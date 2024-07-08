package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/permutation-in-string/

    Cho 2 chuỗi s1, s2. Trả về true nếu s2 chứa một hoán vị của s1, ngược lại trả về false.

    In other words, return true if one of s1's permutations is the substring of s2.
 */
public class MainLeet {

    public boolean checkInclusion(String s1, String s2) {
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, checkInclusion("ab", "eidbaooo"));
    }

}
