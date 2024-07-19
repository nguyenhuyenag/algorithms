package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainTest {

    public static int[] between(int a, int b) {
        int[] arr = IntStream.rangeClosed(a, b).toArray();
        return null;
    }

    @Test
    public void test() {
        int a = 1, b = 10;
        int[] arr = IntStream.rangeClosed(a, b).toArray();
        System.out.println(Arrays.toString(arr));
    }

}
