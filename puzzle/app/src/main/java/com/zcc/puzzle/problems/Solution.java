package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    private Queue<String> q = new LinkedList<>();

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String s: deadends){
            deads.add(s);
        }
        q.offer("0000");
        return BFS(deads, 0 , target);
    }

    public int BFS(Set<String> deadend, int count, String target){
        int level = 0;
        while(q.size()!=0){
            int size = q.size();
            while(size != 0){
                String tar = q.poll();
                if(traced.contains(tar) || deadend.contains(tar)){

                } else if(target.equals(tar)) {
                    return level;
                } else {
                    traced.add(tar);
                    for(int i =0 ; i < 4 ; i ++){
                        for(int j = 0 ; j < 10; j ++){
                            int temp = tar.charAt(i) - '0';
                            if(j == temp){
                                continue;
                            }
                            String ss = tar.substring(0,i) + String.valueOf(j) + tar.substring(i+1,4);
                            if(!deadend.contains(ss) && !traced.contains(ss)){
                                q.offer(ss);
                            }
                            if(ss.equals(target)){
                                return level +1;
                            }
                        }
                    }
                }
                size --;
            }
            level ++;
        }
        return level;
    }
}
