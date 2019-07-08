package com.zcc.puzzle.problems;

import java.util.Stack;

public class ValidSerialization {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) {
            return false;
        }
        if (preorder.length() == 1) {
            return preorder.charAt(0) == '#';
        }
        final char VALID_TREE = '*';
        Stack<String> ss = new Stack<>();
        String[] orders = preorder.split(",");
        for (String c : orders) {
            if (!c.equals("#")) {
                ss.push(c);
            } else {
                while (ss.size() > 0 && (ss.peek().equals("#") || ss.peek().equals("*"))) {
                    ss.pop();
                    if (ss.size() == 0) {
                        return false;
                    }
                    String root = ss.pop();
                    if (root.equals("#") || root.equals("*")) {
                        return false;
                    }
                }
                ss.push("*");
            }
        }
        return ss.size() == 1 && ss.peek().equals("*");
    }

    public static void main(String[] args) {
        ValidSerialization v = new ValidSerialization();
        v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
