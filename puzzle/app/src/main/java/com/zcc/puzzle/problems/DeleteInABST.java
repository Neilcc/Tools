package com.zcc.puzzle.problems;

public class DeleteInABST {
    public static void main(String[] args) {
        DeleteInABST deleteInABST = new DeleteInABST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        deleteInABST.deleteNode(root, 3);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null && tmp.val != key) {
            if (tmp.val > key) {
                parent = tmp;
                tmp = tmp.left;
            } else {
                parent = tmp;
                tmp = tmp.right;
            }
        }
        if (tmp == null) {
            return root;
        } else {
            if (parent == null) {
                return delete(root);
            } else {
                if (parent.left == tmp) {
                    parent.left = delete(tmp);
                } else {
                    parent.right = delete(tmp);
                }
            }
        }
        return root;
    }


    public TreeNode delete(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null) {
            TreeNode p = root;
            TreeNode t = root.right;
            if(t.left == null){
                root.right = delete(t);
                t.left = root.left;
                t.right = root.right;
                return t;
            }
            while (t.left != null) {
                p = t;
                t = t.left;
            }
            TreeNode r = t;
            p.left = delete(t);
            r.left = null;
            r.right = root.right;
            return r;
        } else {
            TreeNode p = root;
            TreeNode t = root.left;
            if(t.right == null){
                root.left = delete(t);
                t.left = root.left;
                t.right = root.right;
                return t;
            }
            while (t.right != null) {
                p = t;
                t = t.right;
            }
            TreeNode r = t;
            p.right = delete(t);
            r.left = root.left;
            r.right = root.right;
            return r;
        }
    }
}
