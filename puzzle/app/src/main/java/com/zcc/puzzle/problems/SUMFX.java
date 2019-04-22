package com.zcc.puzzle.problems;

public class SUMFX {
    public  static class Solution1 {
        public int maxRotateFunction(int[] A) {
            long max = Long.MIN_VALUE ;
            for(long i =0 ; i < A.length; i++){
                long val = f(i, A);
                System.out.print(val);
                System.out.print("\n");
                if(val > max) {
                    max = val;
                }
            }
            return (int)max;
        }

        public long f(long k, int[] a){
            long ret = 0;
            for(long i = 0 ; i < a.length; i ++){
                int index = (int)((i+a.length-1 - k)%a.length);
                ret += i * a[index];
            }
            return ret;
        }
    }

    static class Solution2 {
        public int maxRotateFunction(int[] A) {
            if(A == null) return 0;
            if(A.length <= 1) return 0;
            long [] f = new long [A.length];
            return (int)getF(A, f);
        }

        public long getF(int[] A, long[] f){
            long sum  =0 ;
            for(Integer i : A){
                sum += i;
            }
            f[0] = 0;
            for(int i =0 ; i < A.length ; i ++){
                f[0] += i * A[i];
            }
            long max = f[0];
            for(int i =1; i < A.length ; i ++){
                int index =  A.length - i;
                f[i] = f[i-1] + sum -(A.length) * A[index];
                if(f[i] > max){
                    max = f[i];
                }
            }
            for(long l : f){
                System.out.print(l);
                System.out.print("\n");
            }
            return max;
        }
    }

    public static void main(String args[]){
        Solution1 solution1 = new Solution1();
        int [] A = new int[] {1,2,3,4,5,6,7,8,9,10};
        solution1.maxRotateFunction(A);
        System.out.print("\n");
        System.out.print("\n");
        Solution2 solution2 = new Solution2();
        solution2.maxRotateFunction(A);
    }
}
