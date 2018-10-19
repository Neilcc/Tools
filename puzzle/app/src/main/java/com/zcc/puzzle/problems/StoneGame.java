package com.zcc.puzzle.problems;

public class StoneGame {
    int[][] results;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        results = new int[n][n];
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int result = getSum(piles, 0, n - 1);
        return result > sum / 2;
    }

    private int getSum(int[] piles, int start, int end) {
        if (start > end) return 0;
        if (start - end == 1) {
            int value = Math.max(piles[start], piles[end]);
            results[start][end] = value;
            return value;
        }
        if (results[start][end] != 0) {
            return results[start][end];
        } else {
            int case1 = piles[start] + getSum(piles, start + 2, end);
            int case2 = piles[start] + getSum(piles, start + 1, end - 1);
            int case3 = piles[end] + getSum(piles, start + 1, end - 1);
            int case4 = piles[end] + getSum(piles, start, end - 2);
            int real = max(case1, case2, case3, case4);
            results[start][end] = real;
            return real;
        }
    }

    private int max(int a, int b, int c, int d) {
        int m1 = a > b ? a : b;
        int m2 = c > d ? c : d;
        return m1 > m2 ? m1 : m2;
    }

}
