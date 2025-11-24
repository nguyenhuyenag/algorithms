package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int randomIntInRange(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int[] randomArray(int length, int minValue, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = randomIntInRange(minValue, maxValue);
        }
        return array;
    }

    public static int[] randomArray() {
        int n = randomIntInRange(4, 9);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = randomIntInRange(-20, 20);
        }
        // System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

//    public static void main(String[] args) {
//        randomArrays(5);
//    }

}
