package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public boolean checkDuplicateCharacter(StringBuilder str) {
        boolean[] charSet = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charSet[currentChar - 'a']) {
                return true;
            }
            charSet[currentChar - 'a'] = true;
        }
        return false;
    }

    public int maxLength(List<String> list) {
        int maxLen = 0;
        for (int mask = 0; mask < (1 << list.size()); mask++) {
            StringBuilder substring = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if ((mask & (1 << i)) != 0) {
                    substring.append(list.get(i));
                }
            }
            if (!checkDuplicateCharacter(substring)) {
                maxLen = Math.max(substring.length(), maxLen);
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        assertEquals(4, maxLength(List.of("un", "iq", "ue")));
        assertEquals(6, maxLength(List.of("cha","r","act","ers")));
        assertEquals(26, maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));
    }

//    public static void main(String[] args) {
//        List<String> list = List.of("1", "2", "3", "4");
//        loopSubset(list);
//    }

}
