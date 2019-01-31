package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private List<List<Integer>> ret = new ArrayList<>();

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        ret.clear();
        if (n < k) {
            return ret;
        }
        for (int i = 1; i < n + 1; i++) {
            List<Integer> cc = new ArrayList<>();
            cc.add(i);
            addRest(n + 1, i + 1, k - 1, cc);
            cc.remove(Integer.valueOf(i));
        }
        return ret;
    }

    public void addRest(int max, int start, int level, List<Integer> record) {
        if (level == 0) {
            List<Integer> tar = new ArrayList<>();
            for (Integer ii : record) {
                int iii = (int) ii;
                tar.add(iii);
            }
            ret.add(tar);
            return;
        }
        if (max == start || start - max < level) {
            return;
        }
        for (int i = start; i < max; i++) {
            record.add(i);
            addRest(max, i + 1, level - 1, record);
            record.remove(Integer.valueOf(i));
        }
    }

}
