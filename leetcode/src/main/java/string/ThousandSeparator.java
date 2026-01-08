package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/thousand-separator/
 */
public class ThousandSeparator {

    public String thousandSeparator_OK(int n) {
        if (n < 1_000) return String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int cout = 1;
        while (n > 0) {
            int end = n % 10;
            n /= 10;
            sb.insert(0, end);
            if (cout++ % 3 == 0 && n > 0) {
                sb.insert(0, '.');
            }
        }
        return sb.toString();
    }

    public String thousandSeparator_OK_1(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            count++;
            if (count % 3 == 0 && i > 0) {
                sb.append('.');
            }
        }
        return sb.reverse().toString();
    }

    public String thousandSeparator_OK_2(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        do {
            sb.append(n % 10);
            n /= 10;
            count++;
            if (count % 3 == 0 && n > 0) {
                sb.append('.');
            }
        } while (n > 0);
        return sb.reverse().toString();
    }

    public String thousandSeparator_OK_3(int n) {
        return String.format("%,d", n).replace(',', '.');
    }

    public String thousandSeparator(int n) {
        java.util.Locale.setDefault(java.util.Locale.GERMANY);
        return String.format("%,d", n);
    }

    @Test
    public void test() {
        assertEquals("123", thousandSeparator(123));
        assertEquals("1.234", thousandSeparator(1234));
        assertEquals("0", thousandSeparator(0));
        assertEquals("123.456.789", thousandSeparator(123456789));

    }

}
