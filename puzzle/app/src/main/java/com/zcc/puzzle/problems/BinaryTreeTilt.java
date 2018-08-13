package com.zcc.puzzle.problems;

public class BinaryTreeTilt {

    /**
     * Given a binary tree, return the tilt of the whole tree.
     * <p>
     * The tilt of a tree node is defined as the absolute difference
     * between the sum of all left subtree node values and the sum of all
     * right subtree node values. Null node has tilt 0.
     * <p>
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     * <p>
     * Example:
     * Input:
     * 1
     * /   \
     * 2     3
     * Output: 1
     * Explanation:
     * Tilt of node 2 : 0
     * Tilt of node 3 : 0
     * Tilt of node 1 : |2-3| = 1
     * Tilt of binary tree : 0 + 0 + 1 = 1
     * Note:
     * <p>
     * The sum of node values in any subtree won't exceed the range of 32-bit integer.
     * All the tilt values won't exceed the range of 32-bit integer.
     */


    static int tilt = 0;

    public static void main(String[] args) {

    }

    public static int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }

    public static int sum(TreeNode node) {
        if (node == null) return 0;
        int left = sum(node.left);
        int right = sum(node.right);
        tilt += Math.abs(left - right);
        return left + right + node.val;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
