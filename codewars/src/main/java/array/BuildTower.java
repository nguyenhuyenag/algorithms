package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 - https://www.codewars.com/kata/576757b1df89ecf5bd00073b/

 - In hình tháp
        "     *     ",
        "    ***    ",
        "   *****   ",
        "  *******  ",
        " ********* ",
        "***********"
 */
public class BuildTower {

    public static String[] towerBuilder(int n) {
        String[] ans = new String[n];
        int max = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            String star = "*".repeat(2 * i + 1);
            String space = " ".repeat((max - star.length()) / 2);
            ans[i] = space + star + space;
        }
        return ans;
    }

    @Test
    public void test() {
        assertEquals(String.join(",", "*"), String.join(",", towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", towerBuilder(3)));
    }

}
