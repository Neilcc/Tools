package com.zcc.puzzle.problems;

public class SpiralMatrix {

    public static void main(String[] args){
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int start = 0;
        int end = n - 1;
        int i = 0;
        int j = 0;
        int count = 1;
        while (start <= end) {
            i = start;
            j = start;
            if (start == end) {
                ret[start][start] = count;
                break;
            }
            while (j <= end) {
                ret[i][j] = count++;
                j++;
            }
            j = end;
            i++;
            while (i <= end) {
                ret[i][j] = count++;
                i++;
            }
            i = end;
            j -- ;
            while (j >= start) {
                ret[i][j] = count++;
                j--;
            }
            j = start;
            i -- ;
            while (i > start) {
                ret[i][j] = count++;
                i--;
            }
            i = start;
            start++;
            end--;
        }
        return ret;
    }
}
