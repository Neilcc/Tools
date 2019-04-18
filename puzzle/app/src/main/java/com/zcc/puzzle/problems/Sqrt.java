package com.zcc.puzzle.problems;

public class Sqrt {
    public static void main(String[] arg) {
        System.out.print(mySqrt(2147395600));
    }

    public static int mySqrt(int x) {
        long max = 0;
        for (long i = 0; i <= x; i++) {
            if ((i * i) <= x) {
                max = i;
            } else {
                long  rr = i;
                System.out.print(rr);
                break;
            }
        }
        return (int) max;
    }

}
