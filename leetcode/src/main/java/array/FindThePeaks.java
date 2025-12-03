package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/find-the-peaks/

    Bạn được cho mảng mountain. Hãy tìm các chỉ số của phần tử là đỉnh, tức là lớn
    hơn cả hai phần tử lân cận.

    Lưu ý: phần tử đầu và cuối không được coi là đỉnh.
 */
public class FindThePeaks {

    public List<Integer> findPeaks(int[] mountain) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertIterableEquals(Collections.emptyList(), findPeaks(new int[]{2, 4, 4}));
        assertIterableEquals(Arrays.asList(1, 3), findPeaks(new int[]{1, 4, 3, 8, 5}));
    }

}
