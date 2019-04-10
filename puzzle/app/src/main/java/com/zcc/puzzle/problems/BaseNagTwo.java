package com.zcc.puzzle.problems;

public class BaseNagTwo {

    public String baseNeg2(int N) {
        if(N == 0) return "0";
        StringBuilder ret = new StringBuilder();
        trans(N, ret, false);
        return ret.toString();
    }

    public void trans(int N, StringBuilder ret, boolean isN){
        int a = 0;
        while(N != 0){
            int t = (N & 1) + a;
            a = t / 2;
            t = t % 2;
            N = N >> 1;
            ret.insert(0, t);
            if(isN && t == 1){
                a += 1;
            }
            isN = !isN;
        }
        if(a != 0){
            trans(a, ret , isN);
        }
    }

    public static void main(String [] args){
        BaseNagTwo baseNagTwo = new BaseNagTwo();
        baseNagTwo.baseNeg2(6);
    }
}
