package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

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
        int half= s.length() / 2;
        for (int i = 0; i < half; i++) {
            result.append(s.charAt(i + half));
            result.append(s.charAt(i));
        }
        if (s.length() % 2 != 0) {
            result.append(s.charAt(s.length() - 1));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "xA  SDSDD";
        String encrypt = encryptHelper(s);
        String decrypt = decryptHelper(encrypt);
        System.out.println("encrypt: " + encrypt);
        System.out.println("decrypt: " + decrypt);
        System.out.println("test = " + s.equals(decrypt));
    }

}
