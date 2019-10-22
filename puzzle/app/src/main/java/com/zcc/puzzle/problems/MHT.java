package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by cc on 2019-08-26.
 */
public class MHT {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return new ArrayList<>();
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int[] e : edges) {
            Set<Integer> e1 = nodes.getOrDefault(e[0], new HashSet<>());
            e1.add(e[1]);
            nodes.put(e[0], e1);
            Set<Integer> e2 = nodes.getOrDefault(e[1], new HashSet<>());
            e2.add(e[0]);
            nodes.put(e[1], e2);
        }

        PriorityQueue<Map.Entry<Integer, Set<Integer>>> edgeQ = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Set<Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, Set<Integer>> o1, Map.Entry<Integer, Set<Integer>> o2) {
                int assenble = o1.getValue().size() - o2.getValue().size();
                return -assenble;
            }
        });
        for (Map.Entry entry : nodes.entrySet()) {
            edgeQ.add(entry);
        }
        int max = -1;
        List<Integer> ret = new ArrayList<>();
        while (max < 0 || edgeQ.size() != 0) {
            Map.Entry<Integer, Set<Integer>> entry = edgeQ.poll();
            if (max < 0) {
                max = entry.getValue().size();
                ret.add(entry.getKey());
            } else {
                if (max != entry.getValue().size()) {
                    break;
                }
                ret.add(entry.getKey());
            }
        }
        return ret;
    }
}
