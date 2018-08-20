package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOrderTraversal {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        int level = 0;
        traversal(root, ret, 0);
        return ret;
    }

    public static void traversal(TreeNode node, List<List<Integer>> record, int level) {
        if (node == null) {
            return;
        }
        List<Integer> current = getList(level, record);
        current.add(node.val);
        traversal(node.left, record, level + 1);
        traversal(node.right, record, level + 1);

    }

    public static List<Integer> getList(int level, List<List<Integer>> record) {
        if (record.size() > level) {
            return record.get(level);
        } else {
            for (int i = record.size(); i < level + 1; i++) {
                record.add(new ArrayList<Integer>());
            }
            return record.get(level);
        }
    }

    public static void main(String[] args) {

    }

}
