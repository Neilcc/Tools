package com.zcc.puzzle.problems;

public class SumOfquery {

    public static void main(String[] args){
        SumOfquery sumOfquery = new SumOfquery();
        int [] a = new int[]{1,2,3,4};
        int[][]q = new int[][]{
                {1,0},{-3,1},{-4,0},{2,3}
        };
        sumOfquery.sumEvenAfterQueries(a,q);
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ret = new int [queries.length];
        int evenSum = 0 ;
        for(int i : A){
            if(i % 2 == 0){
                evenSum += i;
            }
        }
        int i = 0;
        for(int[] q : queries){
            int t = A[q[1]];
            boolean evenBefore = (t %2 == 0);
            int result = t + q[0];
            boolean evenAfter = (result % 2 ==0);
            if(evenBefore && evenAfter){
                evenSum += q[0];
            }else if(!evenBefore && evenAfter){
                evenSum += result;
            }else if(evenBefore && !evenAfter){
                evenSum -= t;
            }
            A[q[1]] =  result;
            ret[i] = evenSum;
            i++;
        }
        return ret;
    }
}
