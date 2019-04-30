package com.zcc.puzzle.problems;

import java.util.HashSet;
import java.util.Set;

public class OrderOfLargestPlusSign {

    public static void main(String[] args) {
        OrderOfLargestPlusSign orderOfLargestPlusSign = new OrderOfLargestPlusSign();
        int[][] mm = new int[][]{{4, 2}};
        orderOfLargestPlusSign.orderOfLargestPlusSign(5,mm);
    }

    public int orderOfLargestPlusSign(int N, int[][] mm) {
        int[][] t = new int[N][N];
        int[][] b = new int[N][N];
        int[][] l = new int[N][N];
        int[][] r = new int[N][N];
        int max = 0;
        Set<Integer> mines = new HashSet<>();
        for (int[] ii : mm) {
            mines.add(encode(ii[0], ii[1], N));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                } else {
                    if (mines.contains(encode(i - 1, j, N))) {
                        t[i][j] = 0;
                    } else {
                        t[i][j] = 1 + t[i - 1][j];
                    }

                }
                if (j == 0) {
                    l[i][j] = 0;
                } else {
                    if (mines.contains(encode(i, j - 1, N))) {
                        l[i][j] = 0;
                    } else {
                        l[i][j] = 1 + l[i][j - 1];
                    }
                }
            }
        }

        for (int i = N - 1; i > -1; i--) {
            for (int j = N - 1; j > -1; j--) {
                if (i == N - 1) {
                    b[i][j] = 0;
                } else {
                    if (mines.contains(encode(i + 1, j, N))) {
                        b[i][j] = 0;
                    } else {
                        b[i][j] = 1 + b[i + 1][j];
                    }

                }
                if (j == N - 1) {
                    r[i][j] = 0;
                } else {
                    if (mines.contains(encode(i, j + 1, N))) {
                        r[i][j] = 0;
                    } else {
                        r[i][j] = 1 + r[i][j + 1];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mines.contains(encode(i, j, N))) {
                    continue;
                }
                int val = Math.min(t[i][j], Math.min(b[i][j], Math.min(l[i][j], r[i][j]))) + 1;
                max = Math.max(max, val);

            }
        }
        return max;
    }

    public int encode(int i, int j, int n) {
        return i * n + j;

    }
}
