package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/51e056fe544cf36c410000fb/
 */
public class MainWar {

    public static int arithmetic(int a, int b, String operator) {
        return switch (operator) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    @Test
    void testNotPowersOfTwo() {
    }

}
