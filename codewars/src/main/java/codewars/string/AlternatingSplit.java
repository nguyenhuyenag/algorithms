package codewars.string;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/57814d79a56c88e3e0000786/
 *
 * Mã hóa: Cho chuỗi s, di chuyển các ký tự có index chẵn về cuối, index lẽ lên đầu. Thực hiện n lần.
 *
 * Viết hàm encrypt và decrypt
 */
public class AlternatingSplit {

    public static String encryptHelper(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static String decryptHelper(String s) {
        StringBuilder result = new StringBuilder();
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            result.append(s.charAt(i + half));
            result.append(s.charAt(i));
        }
        if (s.length() % 2 != 0) {
            result.append(s.charAt(s.length() - 1));
        }
        return result.toString();
    }

    public static String encrypt(String text, int n) {
        if (n == 0) return text;
        for (int i = 0; i < n; i++) {
            text = encryptHelper(text);
        }
        return text;
    }

    public static String decrypt(String text, final int n) {
        if (n == 0) return text;
        for (int i = 0; i < n; i++) {
            text = decryptHelper(text);
        }
        return text;
    }

    @Test
    public void testEncrypt() {
        assertEquals("This is a test!", encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", encrypt("This is a test!", 3));
        assertEquals("This is a test!", encrypt("This is a test!", 4));
        assertEquals("This is a test!", encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        assertEquals("This is a test!", decrypt("This is a test!", 0));
        assertEquals("This is a test!", decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", decrypt("This is a test!", 4));
        assertEquals("This is a test!", decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        assertEquals("", encrypt("", 0));
        assertEquals(null, encrypt(null, 0));
        assertEquals("", decrypt("", 0));
        assertEquals(null, decrypt(null, 0));
    }

}
