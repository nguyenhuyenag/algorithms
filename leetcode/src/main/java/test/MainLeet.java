package test;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 */
public class MainLeet {

    public int differenceOfSums(int n, int m) {
        int num1 = IntStream.rangeClosed(1, n)
                .filter(x -> x % m != 0)
                .sum();

        int num2 = IntStream.rangeClosed(1, n)
                .filter(x -> x % m == 0)
                .sum();

        return num1 - num2;
    }

    @Test
    public void test() {
        assertEquals(19, differenceOfSums(10, 3));
    }

}
