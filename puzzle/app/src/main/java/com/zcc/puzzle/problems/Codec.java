package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cc on 2019-11-26.
 */
public class Codec {

    public static void main(String[] args) {
        Codec c = new Codec();
        BTreeSixFiveFive fiveFive = new BTreeSixFiveFive();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);
        String val = c.serialize(t);
        c.deserialize(val);
        Math.random();
        String ss ="";
    }

    private static final char NULL = '#';
    private static final char DIV = '~';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        int height = height(root);
        List<String> ret = new ArrayList<>();
        travel(ret, root, 0, height);
        String retS = "";
        for (String ss : ret) {
            if(!retS.isEmpty()){
                retS+=DIV;
            }
            retS += ss;
        }
        return retS;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        Queue<String> tree = new LinkedList<String>();
        String valS = "";
        for (char c : data.toCharArray()) {
            if (c != DIV) {
                valS += c;
            } else {
                tree.add(valS);
                valS = "";
            }
        }
        tree.add(valS);
        Queue<TreeNode> levelNodes = new LinkedList<TreeNode>();
        String val = tree.poll();
        TreeNode root = new TreeNode(Integer.valueOf(val));
        levelNodes.add(root);
        while (tree.size() > 0) {
            int curSize = levelNodes.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = levelNodes.poll();
                String valL = tree.poll();
                String valR = tree.poll();
                if (curNode == null) {
                    levelNodes.add(null);
                    levelNodes.add(null);
                } else {
                    if (valL.equals(NULL + "")) {
                        curNode.left = null;
                        levelNodes.add(null);
                    } else {
                        TreeNode l = new TreeNode(Integer.valueOf(valL));
                        curNode.left = l;
                        levelNodes.add(l);
                    }
                    if (valR.equals(NULL + "")) {
                        curNode.right = null;
                        levelNodes.add(null);
                    } else {
                        TreeNode r = new TreeNode(Integer.valueOf(valR));
                        curNode.right = r;
                        levelNodes.add(r);
                    }
                }
            }
        }
        return root;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ret = 1;
        int left = height(node.left);
        int right = height(node.right);
        if (left > right) {
            return ret + left;
        } else {
            return ret + right;
        }
    }

    private void travel(List<String> buf, TreeNode root, int level, int max) {
        if (level >= max) {
            return;
        }
        while (buf.size() <= level) {
            buf.add("");
        }
        String s = buf.get(level);
        if (!s.isEmpty()) {
            s += DIV;
        }
        if (root == null) {
            s += NULL;
            buf.set(level, s);
            travel(buf, null, level + 1, max);
            travel(buf, null, level + 1, max);
        } else {
            s += String.valueOf(root.val);
            buf.set(level, s);
            travel(buf, root.left, level + 1, max);
            travel(buf, root.right, level + 1, max);
        }
    }
}