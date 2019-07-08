package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class MountaintoOcean {

    public static void main(String[] args) {
        MountaintoOcean mountaintoOcean = new MountaintoOcean();
        mountaintoOcean.pacificAtlantic(new int[][]
                {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}
        );
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        // Graph
        //1, From pacific borders, which points can be reached
        //2. From atlantic borders, which points can be reached
        //3. if one point can be reached from both pacific and atlantic, it is the result

        // Edge case
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<>();

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];
        // start from pacific: top
        for(int i = 0; i < cols; i++)
            dfs(matrix, canReachPacific, 0, i);
        // start from pacific : left
        for(int j = 0; j < rows; j++)
            dfs(matrix, canReachPacific, j, 0);
        // start from atlantic: right
        for(int i = 0; i < rows; i++)
            dfs(matrix, canReachAtlantic, i, cols - 1);
        // start from atlantic: bottom
        for(int j = 0; j < cols; j++)
            dfs(matrix, canReachAtlantic, rows - 1, j);

        // if point can reach both pacific and atlantic, then it is correct
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(canReachPacific[i][j] && canReachAtlantic[i][j])
                    res.add(new int[]{i, j});

        return res;
    }

    public void dfs(int[][] matrix, boolean[][] canReach, int row, int col) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)   return;
        canReach[row][col] = true;
        if(row + 1 < matrix.length && matrix[row][col] <= matrix[row + 1][col] && canReach[row + 1][col] == false)
            dfs(matrix, canReach, row + 1, col);
        if(row - 1 >= 0 && matrix[row][col] <= matrix[row -1][col] && canReach[row -1][col] == false)
            dfs(matrix, canReach, row - 1, col);
        if(col + 1 < matrix[0].length && matrix[row][col] <= matrix[row][col + 1] && canReach[row][col + 1] == false)
            dfs(matrix, canReach, row, col + 1);
        if(col - 1 >= 0 && matrix[row][col] <= matrix[row][col - 1] && canReach[row][col - 1] == false)
            dfs(matrix, canReach, row, col - 1);
    }

}
