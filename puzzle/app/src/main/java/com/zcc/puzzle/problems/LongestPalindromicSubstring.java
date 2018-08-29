package com.zcc.puzzle.problems;

public class LongestPalindromicSubstring {
    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     * <p>
     * Example 1:
     * <p>
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: "cbbd"
     * Output: "bb"
     */

    static String max = "";

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        return findMax(0, s.length() - 1, s);

    }

    public static String findMax(int start, int end, String s) {
        for (int i = start, j = end; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                String a = max;
                String b =max;
                if (end - start > max.length()) {
                    a = findMax(start + 1, end, s);
                    b = findMax(start, end - 1, s);
                    String maxx =  a.length() > b.length() ? a : b;
                    a = maxx.length()>max.length()? maxx : max;
                }
                return a;
            }
        }
        String newMax = s.substring(start, end + 1);
        max = newMax.length() > max.length() ? newMax : max;
        return newMax;
    }

    public static void main(String[] args) {
       String a =  longestPalindrome("babadada");
       int b = 0;
       a.charAt(b);
    }

}
