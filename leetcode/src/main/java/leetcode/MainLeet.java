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
        String s = "abcdf";
        System.out.println("s.indexOf() = " + s.indexOf("d"));
        System.out.println("s.indexOf() = " + s.substring(0, 1 + s.indexOf('d')));
    }

}
