package com.zcc.puzzle.problems;

public class MaxPalindronicString {
    String max;

    public static void main(String[] args) {
        MaxPalindronicString maxPalindronicString = new MaxPalindronicString();

        String ret = maxPalindronicString.longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        boolean[][] map = new boolean[s.length()][s.length()];
        max = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            map[i][i] = true;
            int p = i - 1;
            int q = i + 1;
            while (p >= 0 && q < s.length()) {
                map[p][q] = map[p + 1][q - 1] && (chars[p] == chars[q]);
                if (map[p][q] && q- p+ 1 > max.length()) {
                    max = s.substring(p, q + 1);
                }
                p--;
                q++;
            }
            if (i + 1 < s.length()) {
                map[i][i + 1] = chars[i] == chars[i + 1];
                if (map[i][i + 1] && max.length() < 2) {
                    max = s.substring(i, i + 2);
                }
                p = i - 1;
                q = i + 2;
                while (p >= 0 && q < s.length()) {
                    map[p][q] = map[p + 1][q - 1] && (chars[p] == chars[q]);
                    if (map[p][q] && q-p + 1 > max.length()) {
                        max = s.substring(p, q + 1);
                    }
                    p--;
                    q++;
                }
            }
        }
        return max;
    }
}
