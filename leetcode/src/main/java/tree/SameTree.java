package tree;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Cả 2 đều null
        if (p == null && q == null) {
            return true;
        }
        // Có 1 tree != null
        if (p == null || q == null) {
            return false;
        }
        // Cả 2 đều != null
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }

}
