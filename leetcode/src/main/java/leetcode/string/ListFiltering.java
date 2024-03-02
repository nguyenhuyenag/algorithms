package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/
 */
public class ListFiltering {

    public static List<Object> filterList(final List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object obj : list) {
            if (Integer.class.isInstance(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    @Test
    public void examples() {
        assertEquals(List.of(1, 2), filterList(List.of(1, 2, "a", "b")));
        assertEquals(List.of(1, 0, 15), filterList(List.of(1, "a", "b", 0, 15)));
        assertEquals(List.of(1, 2, 123), filterList(List.of(1, 2, "aasf", "1", "123", 123)));
    }

}
