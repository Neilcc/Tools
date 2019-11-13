package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by cc on 2019-11-10.
 */
public class FindMinHeight {
    public static void main(String[] args) {
        FindMinHeight findMinHeight = new FindMinHeight();
        findMinHeight.findMinHeightTrees(4, new int[][]{
                {1, 0},
                {1, 2},
                {1, 3}
        });
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0)
            return new ArrayList<>();
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int[] e : edges) {
            Set<Integer> e1 = nodes.getOrDefault(e[0], new HashSet<>());
            e1.add(e[1]);
            nodes.put(e[0], e1);
            Set<Integer> e2 = nodes.getOrDefault(e[1], new HashSet<>());
            e2.add(e[0]);
            nodes.put(e[1], e2);
        }
        Set<Integer> ret = bfs(nodes, n);
        return new ArrayList<>(ret);

    }

    public Set<Integer> bfs(Map<Integer, Set<Integer>> edges, int n) {
        Set<Integer>[] levelNodes = new Set[n];
        Set<Integer> record = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);
        while (q.size() != 0) {
            int leveSize = q.size();
            int i = 0;
            while (i < leveSize) {
                Integer node = q.poll();
                record.add(node);
                Set<Integer> s = levelNodes[level];
                if (s == null) {
                    s = new HashSet<Integer>();
                }
                s.add(node);
                levelNodes[level] = s;
                Set<Integer> next = edges.get(node);
                for (Integer nn : next) {
                    if (!record.contains(nn)) {
                        q.add(nn);
                    }
                }
                i++;
            }
            level++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> level2 = levelNodes[i];
            if (level2 == null) {
                max = i - 1;
                break;
            }
        }
        Set<Integer> s1 = levelNodes[max / 2];
        if (max % 2 == 1) {
            s1.addAll(levelNodes[max / 2 + 1]);
        }
        return s1;

    }
}
