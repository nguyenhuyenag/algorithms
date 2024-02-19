package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

//    public List<String> letterCombinations(String digits) {
//        Map<Integer, String[]> map = new HashMap<>();
//        map.put(2, new String[]{"a", "b", "c"});
//        map.put(3, new String[]{"d", "e", "f"});
//        map.put(4, new String[]{"g", "h", "i"});
//        map.put(5, new String[]{"j", "k", "l"});
//        map.put(6, new String[]{"m", "n", "0"});
//        map.put(7, new String[]{"p", "q", "r", "s"});
//        map.put(8, new String[]{"t", "u", "v"});
//        map.put(9, new String[]{"w", "x", "y", "z"});
//        List<String> result = new ArrayList<>();
//        return result;
//    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Create a mapping of digits to letters
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        // Start the backtracking process
        backtrack(result, digits, digitToLetters, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, Map<Character, String> digitToLetters, int index, StringBuilder currentCombination) {
        // If the current combination is of the same length as the digits, add it to the result
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = digitToLetters.get(digits.charAt(index));

        // Iterate through each letter and recursively call the backtrack function
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(result, digits, digitToLetters, index + 1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    @Test
    public void test() {
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertIterableEquals(expected, letterCombinations("23"));
    }

}
