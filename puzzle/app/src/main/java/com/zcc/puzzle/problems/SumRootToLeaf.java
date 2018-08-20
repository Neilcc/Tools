package com.zcc.puzzle.problems;

import java.util.Stack;

public class SumRootToLeaf {
    /***
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

     An example is the root-to-leaf path 1->2->3 which represents the number 123.

     Find the total sum of all root-to-leaf numbers.

     Note: A leaf is a node with no children.

     Example:

     Input: [1,2,3]
     1
     / \
     2   3
     Output: 25
     Explanation:
     The root-to-leaf path 1->2 represents the number 12.
     The root-to-leaf path 1->3 represents the number 13.
     Therefore, sum = 12 + 13 = 25.
     Example 2:

     Input: [4,9,0,5,1]
     4
     / \
     9   0
     / \
     5   1
     Output: 1026
     Explanation:
     The root-to-leaf path 4->9->5 represents the number 495.
     The root-to-leaf path 4->9->1 represents the number 491.
     The root-to-leaf path 4->0 represents the number 40.
     Therefore, sum = 495 + 491 + 40 = 1026.

     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<Integer> record = new Stack<>();
        traversal(root, record);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node = new TreeNode(9);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        root.left = node;
        root.right = node3;
        node.left = node1;
        node.right = node2;
        sumNumbers(root);
    }

    public static void traversal(TreeNode node, Stack<Integer> record) {
        record.push(node.val);
        if (node.left == null && node.right == null) {
            for (int i = 0; i < record.size(); i++) {
                sum += record.get(record.size() - 1 - i) * Math.pow(10, i);
            }
        } else {
            if (node.left != null) {
                traversal(node.left, record);
            }
            if (node.right != null) {
                traversal(node.right, record);
            }
        }
        record.pop();
    }

    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int currSum){
        if(root == null) return 0;
        currSum = currSum * 10 + root.val;
        if(root.left == null && root.right == null) return currSum;
        int leftSum = helper(root.left,currSum);
        int rightSum = helper(root.right, currSum);
        return leftSum + rightSum;
    }
}
