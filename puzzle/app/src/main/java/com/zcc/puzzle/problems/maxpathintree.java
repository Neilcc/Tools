package com.zcc.puzzle.problems;

public class maxpathintree {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val = maxTraversal(root);
        if(val > max){
            max = val;
        }
        return max;
    }

    public int maxTraversal(TreeNode root){
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val > max){
            max = val;
        }
        int l =0;
        int r =0;
        if(root.left != null){
            l = maxTraversal(root.left);
            System.out.print(l+"\n");
            if(l > max){
                max = l;
            }
        }
        if(root.right != null){
            r = maxTraversal(root.right);
            System.out.print(r + "\n");
            if(r > max){
                max = r;
            }
        }
        return Math.max(Math.max(Math.max(val, val+r), val+r+l), val+l);

    }



    public static void main(String [] args){
        maxpathintree mm = new maxpathintree();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        mm.maxPathSum(root);
    }
}
