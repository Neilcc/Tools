package com.zcc.puzzle.problems;

import java.util.Stack;

public class DecodeString {
    public DecodeString() {
    }

    /**
     * Given an encoded string, return it's decoded string.
     * <p>
     * The encoding rule is: k[encoded_string],
     * where the encoded_string inside the square brackets is being repeated exactly k times.
     * Note that k is guaranteed to be a positive integer.
     * <p>
     * You may assume that the input string is always valid; No extra white spaces,
     * square brackets are well-formed, etc.
     * <p>
     * Furthermore, you may assume that the original data does not contain any digits and
     * that digits are only for those repeat numbers, k. For example, there won't be
     * input like 3a or 2[4].
     * <p>
     * Examples:
     * <p>
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */


    public static void main(String[] args) {
//        String s = decodeStringss("3[a]2[bc]");
//        System.out.print(s);
//        System.out.print("\n");
//        String ss = decodeStringss("3[a2[c]]");
//        System.out.print(ss);
        String sss = decodeStringss("10[le]");
        System.out.print(sss);
    }

    public static String decodeStringss(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> ss = new Stack<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = isNubmer(String.valueOf(c));
            if (ss.size() == 0 && v < 0) {
                ret.append(c);
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                String rr = ss.pop();
                while (!rr.equals("[")) {
                    sb.insert(0, rr);
                    rr = ss.pop();
                }
                int times = 0;
                int weight = 1;
                while (ss.size() >0 && isNubmer(ss.peek()) >=0){
                   times += isNubmer(ss.pop()) * weight;
                   weight *=10;
                }
                String rep = sb.toString();
                for (int j = 0; j < times - 1; j++) {
                    sb = sb.append(rep);
                }
                ss.push(sb.toString());
            } else {
                ss.push(String.valueOf(c));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (ss.size() != 0) {
            sb2.insert(0, ss.pop());
        }
        return ret.append(sb2.toString()).toString();
    }


    public static int isNubmer(String cc) {
        if (cc.length() != 1) return -1;
        char c = cc.charAt(0);
        if ((int) c >= '0' && (int) c <= '9') return (int) c - (int) '0';
        else return -1;

    }


}
