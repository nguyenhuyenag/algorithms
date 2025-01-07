package array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/string-matching-in-an-array/

    Cho mảng các chuỗi. Trả về mảng sau cho mỗi phần tử là chuỗi con của
    một phần tử nào đó trong mảng gốc.
 */
public class StringMatchingInAnArray {

    // Bad solution
    public List<String> stringMatching_Bad(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (words[j].contains(words[i])) {
                        result.add(words[i]);
                        break;
                    }
                }
            }
        }
        return result;
    }

    // Optimize solution
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        // Sort by length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Chỉ kiểm tra nếu chuỗi sau dài hơn chuỗi trước
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public void sortAndTest(List<String> l1, List<String> l2) {
        l1.sort(null);
        l2.sort(null);
        assertIterableEquals(l1, l2);
    }

    @Test
    public void test1() {
        sortAndTest(Arrays.asList("as", "hero"), //
                stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }

    @Test
    public void test2() {
        sortAndTest(Arrays.asList("et", "code"), //
                stringMatching(new String[]{"leetcode", "et", "code"}));
    }

    @Test
    public void test3() {
        sortAndTest(Collections.emptyList(), //
                stringMatching(new String[]{"blue", "green", "bu"}));
    }

}
