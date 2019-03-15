package com.zcc.puzzle.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSColor {
    int N = 0;

    public static void main(String [] arg){
        BFSColor color = new BFSColor();
        int[][] in = new int[][]{
                {0,0,0},
                {0,0,0}
        };
        color.floodFill(in, 0,0 ,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0) return image;
        N = image[0].length;
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> searched = new HashSet<>();
        bfs.add(genCode(sr,sc));
        int val = image[sr][sc];
        while(bfs.size() > 0){
            int a = bfs.poll();
            if(searched.contains(a)){
                continue;
            }
            int ar = a / N;
            int ac = a % N;
            image[ar][ac] = newColor;
            searched.add(a);
            if(ar - 1 >=0 ){
                if(image[ar-1][ac] == val){
                    bfs.add(genCode(ar-1, ac));
                }
            }

            if(ar + 1 < N ){
                if(image[ar+1][ac] == val){
                    bfs.add(genCode(ar+1, ac));
                }
            }

            if(ac -1 >=0){
                if(image[ar][ac-1] == val){
                    bfs.add(genCode(ar,ac-1));
                }
            }

            if(ac +1 < N){
                if(image[ar][ac+1] == val){
                    bfs.add(genCode(ar,ac +1));
                }
            }
        }
        return image;
    }

    public int genCode(int r, int c){
        return N * r + c;
    }


}
