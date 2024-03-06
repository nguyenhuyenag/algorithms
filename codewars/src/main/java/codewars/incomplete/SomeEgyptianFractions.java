package codewars.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/54f8693ea58bce689100065f/
 *
 * Biểu diễn phân số a/b thành tổng của các phân số Ai Cập khác nhau.
 *
 * Phân số Ai Cập là phân số có dạng 1/n
 */
public class SomeEgyptianFractions {

    public static String decompose(String nrStr, String drStr) {
        return ";";
    }

    @Test
    public void test1() {
        assertEquals("[1/2, 1/4]", decompose("3", "4"));
        assertEquals("[3]", decompose("12", "4"));
        assertEquals("[]", decompose("0", "2"));
        assertEquals("[1/2, 1/3, 1/15]", decompose("9", "10"));
    }

}
