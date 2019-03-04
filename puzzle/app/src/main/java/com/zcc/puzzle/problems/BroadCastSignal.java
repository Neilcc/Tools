package com.zcc.puzzle.problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class BroadCastSignal {

    public static void main(String[] args) {
        BroadCastSignal signal = new BroadCastSignal();
        int[][] times = new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 2}
        };
        int coutn = signal.networkDelayTime(times, 3, 1);
        System.out.print(coutn);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                matrix[i][j] = -1;
            }
        for (int i = 0; i < times.length; i++) {
            int[] arg = times[i];
            matrix[arg[0] - 1][arg[1] - 1] = arg[2];
        }
        PriorityQueue<Node> bfs = new PriorityQueue<>(10, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        Set<Integer> searched = new HashSet<>();
        Node n = new Node();
        n.name = K - 1;
        n.w = 0;
        bfs.add(n);
        int ret = 0;
        while (bfs.size() != 0) {
            int lSize = bfs.size();
            Node kk = bfs.poll();
            if (searched.contains(kk.name)) {
                continue;
            }
            int currentW = kk.w;
            List<Node> broadCast = new LinkedList<>();
            broadCast.add(kk);
            while (bfs.size() > 0 && bfs.peek().w == currentW) {
                broadCast.add(bfs.poll());
                lSize--;
            }
            ret += currentW;
            List<Node> toAdd = new LinkedList<>();
            for (Node node : broadCast) {
                int[] arg = matrix[node.name];
                for (int i = 0; i < N; i++) {
                    if (searched.contains(i)) {
                        continue;
                    }
                    if (arg[i] > -1) {
                        Node temp = new Node();
                        temp.name = i;
                        temp.w = arg[i];
                        toAdd.add(temp);
                    }
                }
                searched.add(node.name);
            }
            for (Node node : bfs) {
                node.w -= currentW;
            }
            bfs.addAll(toAdd);
        }
        return ret;
    }

    public static class Node {
        public int name;
        public int w;
    }
}
