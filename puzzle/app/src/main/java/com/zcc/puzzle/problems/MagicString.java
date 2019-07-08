package com.zcc.puzzle.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MagicString {
    public int magicalString(int n) {
        // 1 22 1 1
        // todo 2
        if(n == 0 ) return 0;
        if(n <= 3) return 1;
        int counter = 1;
        int nn = 2;
        String ss = "12";
        Queue<Integer> todo = new LinkedList<>();
        Queue<Integer> vals = new LinkedList<>();
        int[] bet = new int[]{0,2,1};
        todo.add(2);
        vals.add(1);
        int last = 2;
        while(nn < n){
            int val = todo.poll();
            int lastV = vals.poll();
            ss += val;
            if(val == 1){
                counter ++;
            }
            int vv = bet[lastV];
            vals.add(vv);
            for(int i = 0 ; i < val; i ++){
                todo.add(lastV);
            }
            nn ++;
        }
        return counter;
    }

    public static void main (String[] args){
        MagicString m = new MagicString();
        m.magicalString(7);
    }
}
