package codewars.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/550f22f4d758534c1100025a/
 *
 * Cho mảng chứa các hướng dẫn chỉ đường EAST (E), WEST (W), SOUTH (S), NORTH (N).
 * Nếu 2 hướng dẫn E <-> W và S <-> N nằm cạnh nhau thì xem như vỗ nghĩa vì sẽ quay về vị
 * trí cũ. Tiến hành xóa các hướng dẫn vô nghĩa và trả về mảng sau khi xóa
 */
public class DirectionsReduction {

    public static boolean isPair(String s1, String s2) {
        return (s1.equals("NORTH") && s2.equals("SOUTH")) ||
                (s1.equals("SOUTH") && s2.equals("NORTH")) ||
                (s1.equals("EAST") && s2.equals("WEST")) ||
                (s1.equals("WEST") && s2.equals("EAST"));
    }

    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (!stack.isEmpty() && isPair(stack.peek(), s)) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        return stack.stream().toArray(String[]::new);
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    }


}
