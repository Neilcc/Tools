package com.zcc.puzzle.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ChangeMatrix {


    public static void main(String[] args) {
        ChangeMatrix changeMatrix = new ChangeMatrix();
        char[][] b = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        changeMatrix.solve(b);
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) return;
        int len = board[0].length;
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> searched = new HashSet<>();
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                bfs.add(j);
            }
            if (board[board.length - 1][j] == 'O') {
                bfs.add((board.length - 1) * len + j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                bfs.add(i * len);
            }
            if (board[i][len - 1] == 'O') {
                bfs.add(i * len + len - 1);
            }
        }
        while (bfs.size() != 0) {
            int var = bfs.poll();
            int[] pp = decode(var, len);
            if (board[pp[0]][pp[1]] == 'X' || searched.contains(var)) {
                continue;
            }
            searched.add(var);
            int[] pos = decode(var, len);
            if (pos[0] - 1 >= 0) {
                bfs.add(encode(pos[0] - 1, pos[1], len));
            }
            if (pos[0] + 1 < board.length) {
                bfs.add(encode(pos[0] + 1, pos[1], len));
            }
            if (pos[1] - 1 >= 0) {
                bfs.add(encode(pos[0], pos[1] - 1, len));
            }
            if (pos[1] + 1 < board[0].length) {
                bfs.add(encode(pos[0], pos[1] + 1, len));
            }
        }
        for (int m = 0; m < board[0].length; m++) {
            for (int n = 0; n < board.length; n++) {
                if (board[m][n] == 'O' && !searched.contains(encode(m, n, len))) {
                    board[m][n] = 'X';
                }
            }
        }


    }

    private int encode(int i, int j, int l) {
        return i * l + j;
    }

    private int[] decode(int code, int l) {
        int[] ret = new int[2];
        ret[0] = code / l;
        ret[1] = code % l;
        return ret;
    }

}
