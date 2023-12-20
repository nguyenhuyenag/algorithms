package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/5a3fe3dde1ce0e8ed6000097/
 *
 * The first century spans from the year 1 up to and including the year 100,
 * the second century - from the year 101 up to and including the year 200, etc.
 *
 *      1705 --> 18
 *      1900 --> 19
 *      1601 --> 17
 *      2000 --> 20
 */
public class WarMain {

    public static int century(int year) {
        int div = year / 100;
        if (year % 100 == 0) {
            return div;
        } else {
            return div + 1;
        }
    }

    @Test
    public void doTest() {
        assertEquals(18, century(1705));
        assertEquals(19, century(1900));
        assertEquals(17, century(1601));
        assertEquals(20, century(2000));
        assertEquals(1, century(89));
    }

}
