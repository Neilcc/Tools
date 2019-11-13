package com.zcc.puzzle.problems;

public class ProjectionOf3D {
    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int z = 0;
        int x = 0;
        int y = 0;
        for (int[] array : grid) {
            int max = 0;
            for (int ii : array) {
                if (ii > 0) {
                    z++;
                }
                max = ii > max ? ii : max;
            }
            x += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = grid[j][i] > max ? grid[j][i] : max;
            }
            y += max;
        }
        return x + y + z;
    }

    public static void main(String[] args) {
        ProjectionOf3D projectionOf3D = new ProjectionOf3D();
        projectionOf3D.projectionArea(new int[][]{
                {1, 2},
                {3, 4}
        });
    }
}
