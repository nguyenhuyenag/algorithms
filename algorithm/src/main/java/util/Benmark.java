package util;

import org.junit.jupiter.api.Test;

public class Benmark {

    public void measureExecutionTime(Runnable method) {
        long startTime = System.currentTimeMillis();
        method.run();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Thời gian thực thi: " + executionTime + " milliseconds");
    }

    @Test
    public void test_1() {
        measureExecutionTime(() -> {
            String s = "0".repeat(100_000) + "123456789";
            StringBuilder builder = new StringBuilder(s);
            while (!builder.isEmpty() && builder.charAt(0) == '0') {
                builder.deleteCharAt(0);
            }
            System.out.println(builder.toString());
        });
    }

    @Test
    public void test_2() {
        measureExecutionTime(() -> {
            String s = "0".repeat(100_000) + "123456789";
            int index = 0;
            while (index < s.length() && s.charAt(index) == '0'){
                index++;
            }
            System.out.println(s.substring(index));
        });
    }


}
