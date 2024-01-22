package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

//    @Disabled
//    @Test
//    public void test() {
////        assertArrayEquals(new int[]{2, 1}, findErrorNums(new int[]{2,3,2}));
//    }

    public static void main(String[] args) {
        String s = "abcdef";
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length()) {
                System.out.println(s.substring(i-j, i+j+1));
                j++;
            }
        }
    }


}
