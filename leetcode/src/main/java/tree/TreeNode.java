package tree;

// Definition for a binary tree node
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode init(int[] arr) {
        if (arr == null || arr.length != 3) {
            throw new IllegalArgumentException("Array must contain exactly 3 elements: [root, left, right]");
        }

        return new TreeNode(
                arr[0],
                new TreeNode(arr[1]),
                new TreeNode(arr[2])
        );
    }

}
