package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a651865fd56cb55760000e0/
 *
 * Một số gọi là leader nếu nó > tổng các phần tử bên phải nó
 *
 * Tìm tất cả các số leader trong mảng
 */
public class ArrayLeader {

    public static List<Integer> arrayLeaders(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        for (int x : nums) {
            if (x > (sum - x)) {
                result.add(x);
            }
            sum -= x;
        }
        return result;
    }

    @Test
    public void Check_Positive_Values() {
        assertEquals(Arrays.asList(4), arrayLeaders(new int[]{1, 2, 3, 4, 0}));
        assertEquals(Arrays.asList(17, 5, 2), arrayLeaders(new int[]{16, 17, 4, 3, 5, 2}));
    }

    @Test
    public void Check_Negativee_Values() {
        assertEquals(Arrays.asList(-1), arrayLeaders(new int[]{-1, -29, -26, -2}));
        assertEquals(Arrays.asList(-36, -12), arrayLeaders(new int[]{-36, -12, -27}));
    }

    @Test
    public void Mixed_Values() {
        assertEquals(Arrays.asList(5, 2), arrayLeaders(new int[]{5, 2}));
        assertEquals(Arrays.asList(0, -1, 3, 2), arrayLeaders(new int[]{0, -1, -29, 3, 2}));
    }

}
