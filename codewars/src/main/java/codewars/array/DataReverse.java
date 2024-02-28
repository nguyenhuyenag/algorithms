package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://www.codewars.com/kata/569d488d61b812a0f7000015/
 *
 *     Đảo mảng dữ liệu
 *
 *         11111111  00000000  00001111  10101010
 *         (byte1)   (byte2)   (byte3)   (byte4)
 *
 *     thành
 *
 *         10101010  00001111  00000000  11111111
 *         (byte4)   (byte3)   (byte2)   (byte1)
 */
public class DataReverse {

    public static int[] flatList(List<int[]> list) {
        int totalSize = list.stream().mapToInt(arr -> arr.length).sum();
        int[] result = new int[totalSize];
        int index = 0;
        for (int[] arr : list) {
            for (int v : arr) {
                result[index++] = v;
            }
        }
        return result;
    }

    public static int[] dataReverse(int[] data) {
        int chunkSize = 8;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < data.length; i += chunkSize) {
            int[] sub = Arrays.copyOfRange(data, i, i + chunkSize);
            list.add(sub);
        }
        Collections.reverse(list);
        return flatList(list);
    }

    @Test
    public void test() {
        int[] data1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        int[] data2 = {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(data2, dataReverse(data1));
    }

//    public static int[] flatList_OK(List<int[]> list) {
//        List<Integer> result = new ArrayList<>();
//        for (int[] arr : list) {
//            for (int v : arr) {
//                result.add(v);
//            }
//        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }

}
