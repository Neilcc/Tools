package com.zcc.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Hengyun on 2017/1/2.
 */

public class main {


    private static HashMap<Character, Integer> ts = new HashMap<>();
    private static List<List<String>> results = new ArrayList<>();

    public static void main(String[] args) {
//        int[]  p = new int [1];
//        p[0] =1 ;
//        System.out.print(new CaculateABit().hammingWeight(2));
//        char[] ss = new char[]{'1', '2', '3'};
//        System.out.print(String.valueOf(ss));
        Object a = new Object();
        System.out.print(a);
        change(a);
        System.out.print(a);
    }

    public static void change (Object b){
        b = new Object();
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        String min = "";

        for (int i = 0; i < t.length(); i++) {
            Integer tt = ts.get(t.charAt(i));
            if (tt == null) {
                tt = 1;
            } else {
                tt += 1;
            }
            ts.put(t.charAt(i), tt);
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!t.contains(s.charAt(i) + "")) {
                continue;
            }
            for (; j < s.length(); j++) {
                if (j < i) {
                    j = i;
                }
                if (contains(s.substring(i, j + 1), t)) {
                    if (min.length() == 0) {
                        min = s.substring(i, j + 1);
                        break;
                    }
                    if (min.length() > s.substring(i, j + 1).length()) {
                        min = s.substring(i, j + 1);
                        break;
                    }
                    break;
                }
            }
        }

        return min;

    }

    public static boolean contains(String sub, String t) {
        if (sub.length() < t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {

            if (!sub.contains(t.charAt(i) + "")) {
                return false;
            } else if (ts.get(t.charAt(i)) > 1) {
                Integer tt = ts.get(t.charAt(i));
                if (sub.length() - sub.replace(t.charAt(i) + "", "").length() < tt) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String ss = s.trim().toLowerCase();
        int i = 0;
        int j = ss.length() - 1;
        while (true) {
            if (i >= j) {
                return true;
            }
            while (i < s.length() - 1 && (s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
                i++;
            }
            if (i >= j) {
                return true;
            }
            while (j > -1 && (s.charAt(j) < 'a' || s.charAt(j) > 'z') && (s.charAt(j) < '0' || s.charAt(j) > '9')) {
                j--;
            }
            if (j <= i) {
                return true;
            }
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
    }


    /*八皇后问题，深度优先搜索*/
    public static List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            record[0] = i;
            placeCheeses(record, 1);
            record[0] = -1;
        }
        return results;

    }

    private static void placeCheeses(int[] recorded, int n) {
//        第 n 个子 从 0 开始
        if (n == recorded.length) {
//          no  remain
            results.add(coutResult(recorded));
            return;
        }
        for (int i = 0; i < recorded.length; i++) {
//            每个位置都尝试
            if (isPlaceable(n, i, recorded)) {
                recorded[n] = i;
                placeCheeses(recorded, n + 1);
//                回复初值，找下一个。
                recorded[n] = -1;
            }
        }

    }

    private static List<String> coutResult(int[] recorded) {
        List<String> solution = new ArrayList<>();
        for (int x = 0; x < recorded.length; x++) {
            int y = recorded[x];
            String line = "";
            for (int i = 0; i < recorded.length; i++) {
                if (i != y) {
                    line += ".";
                } else {
                    line += "Q";
                }
            }
            solution.add(line);
        }
        return solution;
    }

    private static boolean isPlaceable(int i, int j, int[] recorded) {
        for (int p = 0; p < recorded.length; p++) {
            if (recorded[p] == -1) {
                break;
            }
            if (i == p) {
                return false;
            }
            if (j == recorded[p]) {
                return false;
            }
            if (j - recorded[p] == i - p) {
                return false;
            }

            if (j - recorded[p] == p - i) {
                return false;
            }

        }
        return true;
    }


    public static class Solution {
        private final int Mask = 15;
        private String result = "";

        public String toHex(int num) {
//            if(num < 0){
//                num = (-num)^0xffffffff + 1;
//            }
            int i = num;
            while ((i ^ Mask) > 0) {
                i = getNumber(i);
            }
            return result = getHex(i) + result;
        }

        private int getNumber(int num) {
            int rest = num >> 4;
            result = getHex(num & Mask) + result;
            return rest;

        }

        private String getHex(int num) {
            if (num < 10) {
                return num + "";
            } else {
                return (char) (num - 10 + ((int) 'a')) + "";
            }
        }
    }
}
