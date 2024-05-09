package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/strong-password-checker-ii/
 *
 * A password is said to be strong if it satisfies all the following criteria:
 *
 *      0. It has at least 8 characters.
 *      1. It contains at least one lowercase letter.
 *      2. It contains at least one uppercase letter.
 *      3. It contains at least one digit.
 *      4. It contains at least one special character. The special characters are the
 *         characters in the following string: "!@#$%^&*()-+".
 *      5. It does not contain 2 of the same character in adjacent positions (i.e., "aab"
 *         violates this condition, but "aba" does not).
 *
 * Given a string password, return true if it is a strong password. Otherwise, return false
 */
public class StrongPasswordCheckerII {

    public boolean strongPasswordCheckerII(String password) {
        String specialCharacter = "!@#$%^&*()-+";
        if (password.length() < 8) return false;
        // At least one lowrcase letter
        boolean check1 = password.chars().anyMatch(Character::isLowerCase);
        // At least one uppercase letter
        boolean check2 = password.chars().anyMatch(Character::isUpperCase);
        // At least one digit
        boolean check3 = password.chars().anyMatch(Character::isDigit);
        // At least one special character
        boolean check4 = password.chars().anyMatch(c -> specialCharacter.indexOf(c) != -1);
        // Conditions 5
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }
        return check1 && check2 && check3 && check4;
    }

    @Test
    public void test() {
        assertEquals(true, strongPasswordCheckerII("IloveLe3tcode!"));
        // assertEquals(false, strongPasswordCheckerII("Me+You--IsMyDream"));
        // assertEquals(false, strongPasswordCheckerII("1aB!"));
    }

    //    public boolean strongPasswordCheckerII(String password) {
//        String specialCharacter = "!@#$%^&*()-+";
//        boolean[] validate = new boolean[5];
//        if (password.length() >= 8) {
//            validate[0] = true;
//        }
//        for (char c : password.toCharArray()) {
//            if (Character.isLowerCase(c)) {
//                validate[1] = true;
//            }
//            if (Character.isUpperCase(c)) {
//                validate[2] = true;
//            }
//            if (Character.isDigit(c)) {
//                validate[3] = true;
//            }
//            if (specialCharacter.contains(Character.toString(c))) {
//                validate[4] = true;
//            }
//        }
//        // Check 5 condition
//        for (int i = 0; i < password.length() - 1; i++) {
//            if (password.charAt(i) == password.charAt(i + 1)) {
//                return false;
//            }
//        }
//        for (boolean v : validate) {
//            if (!v) {
//                return false;
//            }
//        }
//        return true;
//    }

}
