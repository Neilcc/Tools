package com.zcc.puzzle.problems;

public class BetterKadane {
    public static void main(String[] arags) {
        BetterKadane betterKadane = new BetterKadane();
        int[] A = new int[]{
                0, 5, 8, -9, 9, -7, 3, -2
        };
        betterKadane.maxSubarraySumCircular(A);
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int[] B = new int[A.length * 2];
        System.arraycopy(A, 0, B, 0, A.length);
        System.arraycopy(A, 0, B, A.length, A.length);
        int i = 0;
        int j = 1;
        int max = A[0];
        int sum = A[0];
        int endJ = A.length - 1;
        while (j <= B.length - 1) {
            if (sum > 0) {
                sum += B[j];
            } else {
                sum = B[j];
                i = j;
                endJ = A.length - 1 + i;
            }
            if (sum > max) {
                max = sum;
            }
            j++;
            if (j > endJ) {
                sum -= B[i];
                endJ++;
                i++;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
