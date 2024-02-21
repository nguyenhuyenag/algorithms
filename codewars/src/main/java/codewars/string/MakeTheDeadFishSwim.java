package codewars.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://www.codewars.com/kata/51e0007c1f9378fa810002a9/
 *     Viết một hàm thực hiện các thao tác sau:
 *         i - increments the value (initially 0)
 *         d - decrements the value
 *         s - squares the value
 *         o - outputs the value into the return array
 */
public class MakeTheDeadFishSwim {

    public static int[] parse(String data) {
        int v = 0;
        List<Integer> result = new ArrayList<>();
        for (char c : data.toCharArray()) {
            switch (c) {
                case 'i' -> v++;
                case 'd' -> v--;
                case 's' -> v *= v;
                case 'o' -> result.add(v);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void exampleTests() {
        assertArrayEquals(new int[] {8, 64}, parse("iiisdoso"));
        assertArrayEquals(new int[] {8, 64, 3600}, parse("iiisdosodddddiso"));
    }

}
