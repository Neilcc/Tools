package com.zcc.puzzle.problems;

import com.zcc.puzzle.tool.HHashMap;

import java.util.HashSet;
import java.util.Set;

public class RMMostStone {
    private int max = 0;
    private HHashMap<Integer, Integer> rMap = new HHashMap();
    private HHashMap<Integer, Integer> cMap = new HHashMap();

    public static void main(String[] args) {
        RMMostStone rmMostStone = new RMMostStone();
        int[][] s = new int[6][2];
        s[0] = new int[]{0, 0};
        s[1] = new int[]{0, 1};
        s[2] = new int[]{1, 0};
        s[3] = new int[]{1, 2};
        s[4] = new int[]{2, 1};
        s[5] = new int[]{2, 2};
        rmMostStone.removeStones(s);
    }

    public int removeStones(int[][] stones) {
        Set<Integer> del = new HashSet();
        for (int i = 0; i < stones.length; i++) {
            int[] pair = stones[i];
            rMap.put(pair[1], rMap.getOrDefault(pair[1], 0) + 1);
            cMap.put(pair[0], cMap.getOrDefault(pair[0], 0) + 1);
        }
        traversal(stones, del);
        return max;
    }

    public void traversal(int[][] stones, Set<Integer> del) {
        boolean canDel = false;
        for (int i = 0; i < stones.length; i++) {
            if (del.contains(i)) {
                continue;
            }
            int countR = rMap.getOrDefault(stones[i][1], 0);
            int countC = cMap.getOrDefault(stones[i][0], 0);
            if (countR >= 2 || countC >= 2) {
                del.add(i);
                rMap.put(stones[i][1], countR - 1);
                cMap.put(stones[i][0], countC - 1);
                traversal(stones, del);
                del.remove(i);
                rMap.put(stones[i][1], countR);
                cMap.put(stones[i][0], countC);
                canDel = true;
            }
        }
        if (!canDel) {
            max = max > del.size() ? max : del.size();
        }
    }
}
