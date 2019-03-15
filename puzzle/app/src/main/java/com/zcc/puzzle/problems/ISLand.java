package com.zcc.puzzle.problems;

import java.util.HashSet;
import java.util.Set;

public class ISLand {

    public static void main(String[] args) {
        ISLand isLand = new ISLand();
        int[][] grid = new int[][]
                {{0, 0, 0, 0}, {1, 0, 0, 0}};

        isLand.islandPerimeter(grid);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int ret = 0;
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int a = getHash(i, j, grid[0].length);
                if (!record.contains(a)) {
                    record.add(a);
                    ret += check(grid, i, j);
                }
            }
        }
        return ret;
    }

    public int check(int[][] grid, int r, int c) {
        int ret = 0;
        if(grid[r][c] == 0){
            return ret;
        }
        if (r - 1 < 0) {
            ret++;
        } else {
            ret += grid[r - 1][c] ^ 1;
        }

        if (r + 1 >= grid.length) {
            ret++;
        } else {
            ret += grid[r + 1][c] ^ 1;
        }

        if (c - 1 < 0) {
            ret++;
        } else {
            ret += grid[r][c - 1] ^ 1;
        }

        if (c + 1 >= grid[0].length) {
            ret++;
        } else {
            ret += grid[r][c + 1] ^ 1;
        }
        return ret;
    }

    public int getHash(int r, int c, int rN) {
        return r * rN + c;
    }
}
