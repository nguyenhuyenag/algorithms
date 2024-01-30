package com.util;

import org.junit.jupiter.api.Test;

public class Benmark {

    public void measureExecutionTime(Runnable method) {
        long startTime = System.currentTimeMillis();
        method.run();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Thời gian thực thi: " + executionTime + " milliseconds");
    }

    private static final int n = 10_000;

    @Test
    public void test_1() {
        measureExecutionTime(() -> {
            concatenateStrings(n);
        });
    }

    @Test
    public void test_2() {
        measureExecutionTime(() -> {
            useStringBuilder(n);
        });
    }

    /**
     * Method test
     */

    public static String concatenateStrings(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "Hello ";
        }
        return result;
    }

    public static String useStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("Hello ");
        }
        return result.toString();
    }

}
