package incomplete;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/*
    https://www.codewars.com/kata/652e9b4b22a196025653b8bf/

    Input
        A String or an empty String
        The given String will not have blank spaces or line breaks
        Output
        A boolean which state if the password is strong enough to pass the game

    Rules
        1. The maximum length of the password is 50 characters
        2. The minimum length of the password is 20 characters
        3. The length of the password must be a prime number
        4. Must have at least 1 lower case, 3 upper case letters and 1 special character
        5. The addition of each of the digits in the password has to be at least 25
        6. Must contains the diminituve of a month
        7. Must contains today's date
        8. Two special characters can't be together
        9. The length of the password must be inside the password

    Clarifications
        The months of the year for this kata are [jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec]
        The months may be in upper case, lower case or combined
        The date inside the password will have the following format yyyyMMdd
        The date numbers count as normal digits for the addition of all
        The special characters for this kata are [-._@#$&]
 */
public class TheSmallPasswordGame {

    // Optimized prime check method
    public static boolean primeCheck(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime numbers
        if (n == 2) return true;  // 2 is the only even prime number
        if (n % 2 == 0) return false; // Other even numbers are not prime
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Optimized rules4 method using a Set for special characters
    public static boolean rules4(char[] arr) {
        int countLower = 0;
        int countUpper = 0;
        int countSpecial = 0;
        int addition = 0;

        Set<Character> special = new HashSet<>();
        for (char c : "-._@#$&".toCharArray()) {
            special.add(c);
        }

        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                countLower++;
            }
            if (Character.isUpperCase(c)) {
                countUpper++;
            }
            if (special.contains(c)) {
                countSpecial++;
            }
            if (Character.isDigit(c)) {
                addition += Character.getNumericValue(c);
            }
        }

        return (countLower >= 1 && countUpper >= 3 && countSpecial >= 1) &&
                addition <= 25;
    }

    // Simplified check method
    public static boolean check(String password, Predicate<String> p) {
        return p.test(password);
    }

    // Refactored validatePassword method
    public static boolean validatePassword(String password) {
        char[] arr = password.toCharArray();
        return check(password, p -> 20 < p.length() && p.length() < 50) &&
                check(password, p -> primeCheck(p.length())) &&
                rules4(arr);
    }

}
