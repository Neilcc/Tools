package com.zcc.puzzle.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinDistance {
    public int[] shortestToChar(String S, char C) {
        int [] ret = new int[S.length()];
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> searched = new HashSet<Integer>();
        for (int i = 0 ; i < S.length(); i ++){
            if(S.charAt(i) == C){
                bfs.add(i);
            }
        }
        int dis = 0;
        while(bfs.size() != 0){
            int size = bfs.size();
            while (size > 0){
                int ii = bfs.poll();
                ret[ii] = dis;
                searched.add(ii);
                if((ii-1) > -1 &&!searched.contains(ii -1) ){
                    bfs.add(ii - 1);
                }
                if((ii+1) < S.length() && !searched.contains(ii+1)){
                    bfs.add(ii+1);
                }
                size --;
            }
            dis ++;
        }
        return ret;
    }

    public static void main (String [] args){
       MinDistance minDistance = new MinDistance() ;
       minDistance.shortestToChar("loveleetcode", 'e');
    }
}
