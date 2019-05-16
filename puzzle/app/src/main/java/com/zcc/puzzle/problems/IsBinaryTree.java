package com.zcc.puzzle.problems;

public class IsBinaryTree {
    private Integer depth = null;
    private Boolean toLow = null;

    public static void main(String[] args) {
        IsBinaryTree isBinaryTree = new IsBinaryTree();
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        System.out.println(isBinaryTree.isBalanced(r));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return traversal(root, 0);
    }

    public boolean traversal(TreeNode root, int level) {
        if (root == null) {
            if (depth == null) {
                depth = level - 1;
                return true;
            } else if (depth == level - 1) {
                return true;
            } else if (toLow == null) {
                toLow = depth > level - 1;
                if (toLow)
                    return depth - level + 1 == 1;
                else
                    return level - 1 - depth == 1;
            } else if (toLow) {
                return depth - level - 1 == 1;
            } else {
                return level - 1 - depth == 1;
            }
        }
        if (root.left == null && root.right == null) {
            if (depth == null) {
                depth = level;
                return true;
            } else if (depth == level) {
                return true;
            } else if (toLow == null) {
                toLow = depth > level;
                if (toLow)
                    return depth - level == 1;
                else
                    return level - depth == 1;
            } else if (toLow) {
                return depth - level == 1;
            } else {
                return level - depth == 1;
            }
        }
        return traversal(root.left, level + 1) && traversal(root.right, level + 1);
    }
}
