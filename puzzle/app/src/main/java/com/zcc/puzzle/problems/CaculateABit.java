package com.zcc.puzzle.problems;

/**
 * Created by Hengyun on 02/03/2017.
 */

public class CaculateABit {
    public int hammingWeight(int n) {
        if(n == 1) return 1 ;
        if(n == 0) return 0 ;
        return n & 1 + hammingWeight (n >>> 1);
    }
}
