package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main (String [] args){
        Solution solution = new Solution();
        String []  deads = new String[]{
                "0201","0101","0102","1212","2002"
        };
        solution.openLock(deads,"0202");
    }

    private Set<String> traced = new HashSet<>();
    private int min = Integer.MAX_VALUE;

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String s: deadends){
            deads.add(s);
        }
        int [] current = new int [] {0,0,0,0};
        BFS(deads, 0 , target,current);
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public int BFS(Set<String> deadend, int count, String target,int[] current){
        if(count > min){
            return -1;
        }
        String s = getS(current);
        if(deadend.contains(s)){
            return -1;
        }
        if(s.equals(target)){
            if(count < min){
                min = count;
            }
            return count;
        }
        traced.add(s);
        List<String> validChildren = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i ++){
            for(int j = 0 ; j < 10 ; j ++){
                int t = current[i];
                if(t == j){
                    continue;
                }else{
                    current[i] = j;
                    String toSearch = getS(current);
                    current[i] = t;
                    if(traced.contains(toSearch)){
                        continue;
                    }
                    traced.add(toSearch);
                    if(toSearch.equals(target)){
                        if(count +1 < min){
                            min = count +1;
                        }
                        return count +1 ;
                    }
                    validChildren.add(toSearch);
                }
            }
        }
        for(int i = 0 ; i < 4 ; i ++){
            for(int j = 0 ; j < 10 ; j ++){
                int t = current[i];
                if(t == j){
                    continue;
                }else{
                    current[i] = j;
                    String toSearch = getS(current);
                    if(traced.contains(toSearch) && !validChildren.contains(toSearch)){
                        continue;
                    }
                    int ret = BFS(deadend, count +1 , target, current);
                    current[i] = t;
                    if(ret > 0 && ret < min){
                        min = ret;
                        return ret;
                    }
                }
            }
        }
        return -1;
    }

    public String getS(int[] current){
        return String.valueOf(current[0]) + current[1] + current[2]+current[3];
    }
}
