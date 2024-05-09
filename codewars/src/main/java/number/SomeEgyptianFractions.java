package number;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/54f8693ea58bce689100065f/
 *
 * Biểu diễn phân số a/b thành tổng của các phân số Ai Cập (phân số dạng 1 / x) khác nhau.
 *
 * a/b = 1/(x + 1) + [a(x + 1) - b] / [b(x + 1)]
 */
public class SomeEgyptianFractions {

    private static class Fraction {
        public long numer;
        public long denom;

        public long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public Fraction(long numer, long denom) {
            long gcd = gcd(numer, denom);
            this.numer = numer / gcd;
            this.denom = denom / gcd;
        }
    }

    public static String decompose(String numer, String denom) {
        long a = Long.parseLong(numer);
        long b = Long.parseLong(denom);

        StringJoiner result = new StringJoiner(", ", "[", "]");

        Fraction frac = new Fraction(a, b);
        if (frac.numer == 0) return "[]";
        if (frac.denom == 1) return "[" + frac.numer + "]";

        while (frac.numer != 1) {
            a = frac.numer;
            b = frac.denom;
            long x = b / a;
            long m = a * (x + 1) - b;
            long n = b * (x + 1);
            String s = x == 0 ? "1" : String.format("1/%d", x + 1);
            result.add(s);
            frac = new Fraction(m, n);
        }
        result.add(frac.numer + "/" + frac.denom);
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("[]", decompose("0", "2"));
        assertEquals("[3]", decompose("12", "4"));
        assertEquals("[1/2, 1/4]", decompose("3", "4"));
        assertEquals("[1/2, 1/3, 1/15]", decompose("9", "10"));
        assertEquals("[1, 1/4]", decompose("5", "4"));
        assertEquals("[1/4]", decompose("2", "8"));
        assertEquals("[1/27055, 1/1359351420]", decompose("13", "351708"));
        assertEquals("[1/84, 1/27055, 1/1359351420]", decompose("50", "4187"));
    }

//    public static String decompose_OK(String numer, String denom) {
//        long a = Long.parseLong(numer);
//        long b = Long.parseLong(denom);
//        StringJoiner result = new StringJoiner(", ", "[", "]");
//        while (a != 0) {
//            long gcd = gcd(a, b);
//            a /= gcd;
//            b /= gcd;
//            if (a == 1 || a % b == 0) {
//                result.add((a == 1) ? String.format("1/%s", b) : String.valueOf(a / b));
//                return result.toString();
//            } else {
//                long x = b / a;
//                long m = a * (x + 1) - b;
//                long n = b * (x + 1);
//                String s = (x == 0) ? "1" : String.format("%d/%d", 1, x + 1);
//                result.add(s);
//                a = m;
//                b = n;
//            }
//        }
//        return result.toString();
//    }

//    public static String decompose(String numer, String denom) {
//        long a = Long.parseLong(numer);
//        long b = Long.parseLong(denom);
//        StringJoiner result = new StringJoiner(", ", "[", "]");
//        while (true) {
//            long gcd = gcd(a, b);
//            a /= gcd;
//            b /= gcd;
//            if (a == 0 || a % b == 0) {
//                return result.toString();
//            } else if (a == 1) {
//                result.add(String.format("1/%s", b));
//                return result.toString();
//            } else if () {
//                result.add(String.valueOf(a / b));
//                return result.toString();
//            } else {
//                long x = b / a;
//                long m = a * (x + 1) - b;
//                long n = b * (x + 1);
//                String s = (x == 0 ? "1" : String.format("%d/%d", 1, x + 1));
//                result.add(s);
//                a = m;
//                b = n;
//            }
//        }
//    }

}
