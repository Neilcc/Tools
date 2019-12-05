package com.zcc.puzzle.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2019-12-05.
 * [["a","b"],["b","c"]]
 * [2.0,3.0]
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 */
public class Divider {
    public static void main(String[] args) {
        Divider divider = new Divider();
        List<List<String>> eqs = new LinkedList<>();
        List<List<String>> queries = new LinkedList<>();
        eqs.add(Arrays.asList("a", "b"));
        eqs.add(Arrays.asList("b", "c"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        divider.calcEquation(eqs, new double[]{2, 3}, queries);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> vals = equations.get(i);
            String a1 = vals.get(0);
            String a2 = vals.get(1);
            HashMap<String, Double> a1map = map.getOrDefault(a1, new HashMap<String, Double>());
            a1map.put(a2, values[i]);
            map.put(a1, a1map);
            HashMap<String, Double> a2map = map.getOrDefault(a2, new HashMap<>());
            a2map.put(a1, 1 / values[i]);
            map.put(a2, a2map);
        }
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            HashMap<String, Double> qmap = map.get(q.get(0));
            if (qmap == null) {
                ret[i] = -1.0;
                continue;
            }
            if (qmap.get(q.get(1)) != null) {
                ret[i] = qmap.get(q.get(1));
            } else {
                HashMap<String, Double> qmap2 = map.get(q.get(1));
                if (qmap2 == null) {
                    ret[i] = -1.0;
                    continue;
                }
                if (q.get(0).equals(q.get(1))) {
                    ret[i] = 1.0;
                    continue;
                }
                // Set<String> key1 = qmap.keySet();
                // Set<String> key2 = qmap2.keySet();
                // boolean hasresult = false;
                // for (String s : key1) {
                // if (key2.contains(s)) {
                // hasresult = true;
                // ret[i] = qmap.get(s) / qmap2.get(s);
                // break;
                // }
                // }
                // if (!hasresult) {
                // ret[i] = -1.0;
                // }
                ret[i] = dfs(map, q.get(0), q.get(1), new HashSet<>(), 1.0);
            }
        }
        return ret;
    }

    public double dfs(HashMap<String, HashMap<String, Double>> map, String a, String b, Set<String> traced,
                      Double curval) {
        if (map.get(a) == null || traced.contains(a) || (curval != null && curval == -1.0)) {
            return -1.0;
        }
        Set<String> nextTraced = new HashSet<>();
        nextTraced.addAll(traced);
        nextTraced.add(a);
        HashMap<String, Double> amap = map.get(a);
        for (String next : amap.keySet()) {
            if (traced.contains(next)) {
                continue;
            }
            double nextVal;
            if (curval == null) {
                nextVal = amap.get(next);
            } else {
                nextVal = curval * amap.get(next);
            }
            if (next.equals(b)) {
                return nextVal;
            }
            double val = dfs(map, next, b, nextTraced, nextVal);
            if (val != -1.0) {
                return val;
            }
        }
        return -1.0;
    }
}
