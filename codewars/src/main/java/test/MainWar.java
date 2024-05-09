package test;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class MainWar {

    public static Integer find(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return arr[i + 1];
            }
        }
        return null;
    }

    @Test
    public void sampleTests() {
    }

}
