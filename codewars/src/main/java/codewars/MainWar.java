package codewars;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainWar {

    public static long maxProduct(int[] arr, int sub_size) {
        Arrays.sort(arr);
        int max1 = 1, max2 = 1;
        for (int i = 0; i < sub_size; i++) {
            max1 *= arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            max2 *= arr[i];
            sub_size--;
            if (sub_size == 0) {
                break;
            }
        }
        return Math.max(max1, max2);
    }

    @Test
    public void Return_Maximum_Product() {
        assertEquals(20, maxProduct(new int[]{4, 3, 5}, 2));
        // assertEquals(720, maxProduct(new int[]{10, 8, 7, 9}, 3));
        // assertEquals(288, maxProduct(new int[]{8, 6, 4, 6}, 3));
    }

//    @Test
//    public void Checks_Larger_Vector_Size() {
//        assertEquals(9600, maxProduct(new int[]{10, 2, 3, 8, 1, 10, 4}, 5));
//        assertEquals(247895375, maxProduct(new int[]{13, 12, -27, -302, 25, 37, 133, 155, -14}, 5));
//    }
//
//    @Test
//    public void Checks_Negative_Values() {
//        assertEquals(4, maxProduct(new int[]{-4, -27, -15, -6, -1}, 2));
//        assertEquals(136, maxProduct(new int[]{-17, -8, -102, -309}, 2));
//    }
//
//    @Test
//    public void Checks_Mixture_Values() {
//        assertEquals(-30, maxProduct(new int[]{10, 3, -27, -1}, 3));
//        assertEquals(-253344, maxProduct(new int[]{14, 29, -28, 39, -16, -48}, 4));
//    }

}
