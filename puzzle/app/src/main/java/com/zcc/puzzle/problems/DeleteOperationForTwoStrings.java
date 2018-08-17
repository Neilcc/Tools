package com.zcc.puzzle.problems;

public class DeleteOperationForTwoStrings {
    /**
     * Given two words word1 and word2, find the minimum number of steps required to make word1 and
     * word2 the same, where in each step you can delete one character in either string.
     * <p>
     * Example 1:
     * Input: "sea", "eat"
     * Output: 2
     * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     * Note:
     * The length of given words won't exceed 500.
     * Characters in given words can only be lower-case letters.
     */
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int max = maxSubSequence(word1, word2);
        return word1.length() + word2.length() - 2 * max;
    }

    public static void main(String[] args) {
        int i = minDistance("mart", "karma");
    }

    /**
     * if(si == sj)
     * f(i,j) = 1+ f(si-1, sj-1)
     * else
     * f(i,j) = max f(si-1, sj-1)
     */
    public static int maxSubSequence(String s1, String s2) {
        int[][] map = new int[s1.length()][s2.length()];
        map[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0) {
                    if (s2.substring(0, j + 1).contains(s1.charAt(0) + "")) map[i][j] = 1;
                    else map[i][j] = 0;
                } else if (j == 0) {
                    if (s1.substring(0, i + 1).contains(s2.charAt(0) + "")) map[i][j] = 1;
                    else map[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    map[i][j] = 1 + map[i - 1][j - 1];
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        return map[s1.length() - 1][s2.length() - 1];
    }

}
