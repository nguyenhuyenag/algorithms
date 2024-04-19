package com.tree;


import com.util.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*-
 * (1) Definition for tree node:
 *   - Root là nút không có nút cha (một cây có nhiều nhất một root).
 *   - Edge là biểu thị liên kết từ nút cha đến nút con.
 *   - Node lá (leaf) là nút không có nút con.
 *   - Siblings là những nút có cùng nút cha.
 *   - Nút A là ancestor (tổ tiên) của B nếu đi từ Root đến B có đi qua A. Nút B là descendant (con cháu) của A.
 *   - Tập hợp các node ở cùng một độ sâu nhất định gọi là level của cây. Root là ở mức 0.
 *   - Độ sâu của node là độ dài đường đi từ root đến node đó.
 *   - Chiều cao của node là độ dài đường đi từ root đến node đó.
 *   - Chiều cao của tree là độ dài từ root đến node sâu nhất.
 *   - Kích thước của một node là số lượng node con + chính node đó.
 *
 * (2) Cây nhị phân (binary tree):
 *   - Là cây mà mỗi node có nhiều nhất 2 node con.
 *   - Các loại cây nhị phân
 *     + Cây nhị phân nghiêm ngặt (strict BT) là cây mà mỗi node có 0 hoặc 2 node con
 *     + Cây nhị phân đây đủ (full BT) là cây mà mỗi node có đúng 2 node con và các node lá ở cùng một mức.
 *     + Cây nhị phân hoàn chỉnh (completed BT) ???
 */
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

    // Phương thức để chèn một giá trị mới vào cây nhị phân
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Phương thức để tạo cây nhị phân từ một mảng các giá trị
    public static TreeNode createBinaryTree(int[] array) {
        TreeNode root = null;
        for (int val : array) {
            root = insert(root, val);
        }
        return root;
    }

    // Phương thức duyệt cây nhị phân theo thứ tự trước và in ra cấu trúc của cây
    public static void printTreeStructure(TreeNode root) {
        if (root == null)
            return;
        int maxLevel = maxLevel(root);
        printTreeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printTreeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (TreeNode node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }
        printTreeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3};
        System.out.println(Arrays.toString(values));
        TreeNode root = createBinaryTree(values);
        System.out.println("Tree structure:");
        printTreeStructure(root);
    }

}


