package com.zcc.puzzle.problems;

public class Pma {


    public static void main(String [] args){
        Pma pma = new Pma();
        pma.countSubstrings("fdsklf");
    }

    public int countSubstrings(String s) {
        // positive mean self is palindromic, negative means not;
        int[][] f = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            f[i][i] = 1;
            if (i + 1 < s.length() && chars[i] == chars[i + 1]) {
                f[i][i + 1] = 1;
            } else if (i + 1 < s.length()) {
                f[i][i + 1] = -1;
            }
        }
        for (int step = 2; step < chars.length; step++) {
            for (int i = 0; i < chars.length - step; i++) {
                if (chars[i] != chars[i + step]) {
                    f[i][i + step] = -1;
                } else {
                    if (i + 1 <= i + step - 1) {
                        f[i][i + step] = 1;
                    } else if (f[i + 1][i + step - 1] > 0) {
                        f[i][i + step] = 1;
                    } else {
                        f[i][i + step] = -1;
                    }
                }
            }
        }
        int cc = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[j][i] > 0) {
                    cc++;
                }
            }
        }
        return cc;
    }
}
