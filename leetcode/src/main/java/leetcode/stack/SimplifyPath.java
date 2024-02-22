package leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://leetcode.com/problems/simplify-path/
 *
 * The canonical path should have the following format:
 *
 * - The path starts with a single slash '/'.
 * - Any two directories are separated by a single slash '/'.
 * - The path does not end with a trailing '/'.
 * - The path only contains the directories on the path from the root
 *   directory to the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 */
public class SimplifyPath {

    public String simplifyPath(String paths) {
        Stack<String> stack = new Stack<>();
        // System.out.println("stack = " + Arrays.toString(paths.split("/")));
        for (String path : paths.split("/")) {
            if (path.isEmpty() || ".".equals(path)) {
                continue;
            } else if ("..".equals(path)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(path);
            }
        }
        return "/" + String.join("/", stack);
    }

    @Test
    public void test() {
        assertEquals("/home", simplifyPath("/home/"));
        assertEquals("/", simplifyPath("/../"));
        assertEquals("/home/foo", simplifyPath("/home//foo/"));
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }

}
