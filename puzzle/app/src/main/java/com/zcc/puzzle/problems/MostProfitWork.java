package com.zcc.puzzle.problems;

import java.util.Arrays;

public class MostProfitWork {


    public static void main(String[] args) {
        MostProfitWork mostProfitWork = new MostProfitWork();
        //[]
        //[67,17,1,81,3]
        //[92,10,85,84,82]
        int[] d = new int[]{
                68, 35, 52, 47, 86
        };

        int[] p = new int[]{
                67, 17, 1, 81, 3
        };

        int[] w = new int[]{
                92, 10, 85, 84, 82
        };
        mostProfitWork.maxProfitAssignment(d,p,w);
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (profit == null || profit.length == 0 || worker == null || worker.length == 0) return 0;
        int total = 0;
        sortProfit(profit, difficulty, 0, profit.length - 1);
        Arrays.sort(worker);
        for (int i = worker.length - 1; i >= 0; i--) {
            for (int j = profit.length - 1; j >= 0; j--) {
                if (difficulty[j] <= worker[i]) {
                    total += profit[j];
                    break;
                }
            }
        }
        return total;
    }

    public void sortProfit(int[] profit, int[] difficulty, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = profit[start];
        int pivotDif = difficulty[start];
        int p = start;
        int q = end;
        while (p < q) {
            while (profit[q] >= pivot && p < q) {
                q--;
            }
            if (p < q) {
                profit[p] = profit[q];
                difficulty[p] = difficulty[q];
                p++;
            }
            while (profit[p] <= pivot && p < q) {
                p++;
            }
            if (p < q) {
                profit[q] = profit[p];
                difficulty[q] = difficulty[p];
                q--;
            }
        }
        profit[p] = pivot;
        difficulty[p] = pivotDif;
        sortProfit(profit, difficulty, start, p - 1);
        sortProfit(profit, difficulty, p + 1, end);
    }
}
