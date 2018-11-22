package com.zcc.puzzle.problems;

public class SortPeople {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) return people;
        int[][] ret = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < 2; j++) {
                ret[i][j] = -1;
            }
        }
        for (int i = people.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (people[j - 1][0] < people[j][0]) {
                    swap(people[j - 1], people[j]);
                } else if (people[j - 1][0] == people[j][0]) {
                    if (people[j - 1][1] < people[j][1]) {
                        swap(people[j - 1], people[j]);
                    }
                }
            }
            int k = people[i - 1][1];
            if(k == 0){
                while(ret[k][1] != -1){
                    k++;
                }
                ret[k] = people[i-1];
                continue;
            }
            int count = 0;
            int p = 0;
            while (count < k) {
                if (ret[p][1] == -1 || ret[p][0] >= people[i-1][0]) {
                    count++;
                }
                p++;
            }
            while (ret[p][1] != -1) {
                p++;
            }
            ret[p] = people[i - 1];
        }
        return ret;
    }

    private static void swap(int[] a, int[] b) {
        int[] t = new int[2];
        t[0] = a[0];
        t[1] = a[1];
        a[0] = b[0];
        a[1] = b[1];
        b[0] = t[0];
        b[1] = t[1];
    }

    public static void main(String[] arg) {
        int[][] p = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        int[][] q = reconstructQueue(p);
    }
}
