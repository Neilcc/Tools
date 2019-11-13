package com.zcc.puzzle.problems;

import java.util.Arrays;
import java.util.HashMap;

public class TreeModel {
    public static void main (String[] args){
        TreeModel treeModel = new TreeModel();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        treeModel.find(root);
    }
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        int[] val = find(root);
        int[] ret = new int[val.length -1];
        for(int i = 0 ; i < ret.length; i ++){
            ret[i] = val[i+1];
        }
        return ret;
    }

    public int[] find(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return new int[]{1, root.val};
        }
        int[] left =null;
        boolean inleft = false;
        int valCount  = 1;
        if(root.left != null){
            left = find(root.left);
            for(int i = 1 ; i < left.length ; i ++){
                if(left[i] == root.val){
                    valCount += left[0];
                    inleft = true;
                    break;
                }
            }
        }
        int[] right = null;
        boolean inright = false;
        if(root.right != null){
            right = find(root.right);
            for(int i = 1 ; i < right.length ; i ++){
                if(right[i] == root.val){
                    valCount += right[0];
                    inright = true;
                    break;
                }
            }
        }
        int lm = left == null ? 0: left[0];
        int rm = right == null ? 0 : right[0];
        if(inleft && inright){
            return new int[]{valCount, root.val};
        }else if(!inleft && inright){
            if(valCount == lm){
                int[] ret = Arrays.copyOf(left, left.length +1);
                ret[ret.length -1] = root.val;
                return ret;
            }else if(valCount > lm){
                return new int[]{valCount, root.val};
            }else{
                return left;
            }
        }else if(!inright && inleft){
            // !inright inleft
            if(valCount == rm){
                int[] ret = Arrays.copyOf(right, right.length +1);
                ret[ret.length -1] = root.val;
                return ret;
            }else if(valCount > rm){
                return new int[]{valCount, root.val};
            }else {
                return right;
            }
        }else{
            // !r !l
            if(rm == lm){
                if(valCount == rm){
                    int [] ret = new int[left.length + right.length +1];
                    System.arraycopy(left, 0, ret,0, left.length);
                    System.arraycopy(right, 0, ret,left.length, right.length);
                    ret[ret.length -1] = root.val;
                    return ret;
                }else {
                    int [] ret = new int[left.length + right.length];
                    System.arraycopy(left, 0, ret,0, left.length);
                    System.arraycopy(right, 0, ret,left.length, right.length);
                    return ret;
                }
            }else if(rm > lm){
                if(valCount == rm){
                    int [] ret = Arrays.copyOf(right, right.length +1);
                    ret[ret.length -1] = root.val;
                    return ret;
                }else{
                    return right;
                }
            }else{
                if(valCount == lm){
                    int [] ret = Arrays.copyOf(left, left.length +1);
                    ret[ret.length -1] = root.val;
                    return ret;
                }else{
                    return left;
                }
            }
        }
    }
}
