package com.zcc.puzzle.problems;

public class ToWin {
    public static void main(String[] args) {
        ToWin toWin = new ToWin();
        toWin.divisorGame(6);
    }

    public boolean divisorGame(int N) {
        int[] val = new int[N + 1];
        val[0] = 0;
        val[1] = 0;
        for (int i = 2; i <= N; i++) {
            double r = Math.sqrt(i);
            int win = 0;
            for (int j = 1; j <= (int) r; j++) {
                if (i % j != 0) {
                    continue;
                } else {
                    if ((1 ^ val[i - j]) == 1) {
                        win = 1;
                        break;
                    }
                }
            }
            val[i] = win;
        }
        return val[N] == 1;
    }


}
