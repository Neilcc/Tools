package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class BTreeSixFiveFive {

    public static void main(String [] args){
       BTreeSixFiveFive fiveFive = new BTreeSixFiveFive();
       TreeNode t = new TreeNode(3);
       t.left = new TreeNode(1);
       t.right = new TreeNode(5);
       t.left.left = new TreeNode(0);
       t.left.right = new TreeNode(2);
       t.right.left = new TreeNode(4);
       t.right.right = new TreeNode(6);
       t.left.right.left = new TreeNode(3);
       System.out.print(fiveFive.printTree(t).toString());
    }


    public List<List<String>> printTree(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<String>> ret = new ArrayList<>();
        List<List<String>> left = printTree(root.left);
        List<List<String>> right = printTree(root.right);
        if(left == null && right == null){
            ArrayList<String> init = new ArrayList<>();
            init.add(String.valueOf(root.val));
            ret.add(init);
            return ret;
        }else if(left == null){
            left = handleNull(right);
        }else if(right == null){
            right = handleNull(left);
        }
        int nMax = left.size() > right.size() ? left.size(): right.size();
        int mMax = left.get(0).size()> right.get(0).size()? left.get(0).size():right.get(0).size();
        ArrayList<String> t  =new ArrayList<>();
        t.add(String.valueOf(root.val));
        for(int i = 0 ; i < mMax ; i ++){
            t.add(0, "");
            t.add("");
        }
        ret.add(t);
        for(int i =  0; i<nMax; i ++ ){
            ArrayList<String> tt = new ArrayList<>();
            List<String> l = null;
            List<String> r = null;
            if(i<left.size()){
                l = left.get(i);
            }
            if(i<right.size()){
                r = right.get(i);
            }
            if(l == null){
                l = cons(mMax);
            }
            if(r == null){
                r = cons(mMax);
            }
            if(l.size() < mMax){
                l = extend(l, mMax);
            }
            if(r.size()< mMax){
                r = extend(r, mMax);
            }
            tt.addAll(l);
            tt.add("");
            tt.addAll(r);
            ret.add(tt);
        }
        return ret;
    }

    private List<String> extend(List<String> t, int m){
        int mid = t.size() /2;
        if(t.get(mid).equals("")){
            for(int i = t.size() ; i < m; i += 4){
                t.add(mid,"");
                t.add(mid,"");
                t.add(0, "");
                t.add("");
            }
        }else{
            for(int i = t.size() ; i < m; i += 2){
                t.add(0,"");
                t.add("");
            }
        }
        return t;
    }

    private ArrayList<String> cons(int size){
        ArrayList<String> ret = new ArrayList<>();
        for(int i =0 ;i < size; i ++){
            ret.add("");
        }
        return ret;

    }

    private List<List<String>> handleNull(List<List<String>> nonNull){
        List<List<String>> ret = new ArrayList<>();
        ArrayList<String> sub = new ArrayList<>();
        for(int j = 0 ; j <nonNull.get(0).size(); j++){
            sub.add("");
        }
        for(int i = 0 ; i < nonNull.size(); i ++){
            ret.add((ArrayList<String>)sub.clone());
        }
        return ret;
    }
}
