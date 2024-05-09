package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/550554fd08b86f84fe000a58/
 *
 * Cho 2 mảng a1, a2. Trả về mảng sắp xếp mà các phần tử thuộc a1 là con của a2
 */
public class WhichAreIn {

    public static boolean checkSubString(String[] arr, String target) {
        return Arrays.stream(arr).anyMatch(s -> s.contains(target));
    }

    public static String[] inArray(String[] a1, String[] a2) {
        return Arrays.stream(a1)
                .filter(s -> checkSubString(a2, s))
                .sorted()
                .toArray(String[]::new);
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{"arp", "live", "strong"}, inArray(new String[]{"arp", "live", "strong"}, new String[]{"lively", "alive", "harp", "sharp", "armstrong"}));
    }

}
