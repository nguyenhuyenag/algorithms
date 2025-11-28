package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tree.TreeNode.init;

/*-
    https://leetcode.com/problems/root-equals-sum-of-children/

    Cho một cây nhị phân có 3 3 node (gốc, trái, phải). Kiểm tra xem giá trị
    của nút gốc có bằng tổng giá trị của các con nó hay không.
 */
public class RootEqualsSumOfChildren {

    public boolean checkTree(TreeNode root) {
        return root == null || root.val == root.left.val + root.right.val;
    }

    @Test
    public void test_1() {
        TreeNode root = init(new int[]{10, 4, 6}); // root=10, left=4, right=6
        assertTrue(checkTree(root));
    }

    @Test
    public void test_2() {
        TreeNode root = init(new int[]{5, 3, 1});
        assertFalse(checkTree(root));
    }

}
