package com;

import java.util.*;
import java.util.stream.Collectors;

public class AlgMain {

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        long a = 7;
        long b = 9515459940L;
        long v = gcd(a, b);
        System.out.println("v = " + v);
    }

}
