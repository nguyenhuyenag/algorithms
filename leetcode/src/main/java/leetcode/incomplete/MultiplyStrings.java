package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
 *       2 7
 *  x    3 6
 *  -----------
 *     1 6 2
 *     8 1
 *  -----------
 *     9 7 2
 */
public class MultiplyStrings {

    public String multiply(String s1, String s2) {
        int p = 0;
        List<String> listNum = new ArrayList<>();
        for (int i = s1.length() - 1; i >= 0; i--) {
            int rem = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = s2.length() - 1; j >= 0; j--) {
                int n1 = Character.getNumericValue(s1.charAt(i));
                int n2 = Character.getNumericValue(s2.charAt(j));
                // System.out.print(n1 + "x" + n2 + " ");
                int prod = n1 * n2 + rem;
                rem = prod / 10;
                builder.append(prod % 10);
            }
            if (rem > 0) {
                builder.append(rem);
            }
            listNum.add(builder.reverse().append("0".repeat(p++)).toString());
            // System.out.println();
        }
        System.out.println(listNum);
        return "";
    }

    @Test
    public void test() {
        assertEquals("972", multiply("36", "27"));
        // assertEquals("56088", multiply("123", "456"));
    }

}
