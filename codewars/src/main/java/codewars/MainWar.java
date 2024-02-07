package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/541c8630095125aba6000c00/
 */
public class MainWar {

    public static boolean solution(String s1, String s2) {
        String sub = s1.substring(s1.length() - s2.length());
        return s1.endsWith(s2);
    }


    @Test
    public void test() {
//        assertEquals(7, digital_root(16));
//        assertEquals(6, digital_root(942));
//        assertEquals(6, digital_root(132189));
//        assertEquals(2, digital_root(493193));
        TreeSet<Integer> tree = new TreeSet<>();
        tree.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(tree.first());
        System.out.println(tree.last());
    }

}
