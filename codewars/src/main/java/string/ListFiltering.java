package string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/
 *
 * Lọc ra số từ danh sách cácc chuỗi và số chứ số và ký tự
 */
public class ListFiltering {

    public static List<Object> filterList_OK(final List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object obj : list) {
            if (Integer.class.isInstance(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(t -> Integer.class.isInstance(t))
                .toList();
    }

    @Test
    public void examples() {
        assertEquals(List.of(1, 2), filterList(List.of(1, 2, "a", "b")));
        assertEquals(List.of(1, 0, 15), filterList(List.of(1, "a", "b", 0, 15)));
        assertEquals(List.of(1, 2, 123), filterList(List.of(1, 2, "aasf", "1", "123", 123)));
    }

}
