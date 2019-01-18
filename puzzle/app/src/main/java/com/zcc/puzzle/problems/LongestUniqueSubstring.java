package com.zcc.puzzle.problems;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        char[] chars = s.toCharArray();
        String r = chars[0] + "";
        String max = r;
        int i = 0;
        int j = 1;
        while (true) {
            if (j >= s.length()) {
                break;
            }
            if (i == j) {
                j++;
                r = chars[i] +"";
                continue;
            }
            if (r.contains(chars[j] + "")) {
                i++;
                r = s.substring(i, j);
            } else {
                r = r + chars[j];
                if (r.length() > max.length()) {
                    max = r;
                }
                j++;
            }
        }
        return max.length();
    }

    public static void main (String [] args){
       LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
       longestUniqueSubstring.lengthOfLongestSubstring("aab");
    }
}
