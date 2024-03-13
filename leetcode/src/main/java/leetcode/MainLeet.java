package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public static void main(String[] args) {
        String s = "";
        int[] mark1 = new int[26];
        int[] mark2 = new int[26];
        s.chars().forEach(c -> {
            mark1[c - 'a']++;
            mark2[c - 'a']++;
        });
        System.out.println(Arrays.hashCode(mark1));
        System.out.println(Arrays.hashCode(mark2));
    }

}
