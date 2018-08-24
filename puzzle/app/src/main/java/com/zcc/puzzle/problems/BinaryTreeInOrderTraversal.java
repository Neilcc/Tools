package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    private List<Integer> record = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return record;
    }

    public void inorder(TreeNode treeNode) {
        if (treeNode == null) return;
        inorder(treeNode.left);
        record.add(treeNode.val);
        inorder(treeNode.right);
    }


}
