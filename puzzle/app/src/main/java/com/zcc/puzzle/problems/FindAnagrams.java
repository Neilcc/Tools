package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams anagrams = new FindAnagrams();
        List<Integer> val = anagrams.findAnagrams("cbaebabacd"
                , "abc");
        System.out.println(val);

    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || s.length() < p.length()) return new ArrayList<>();
        Map<Character, Integer> ps = new HashMap();
        for (char c : p.toCharArray()) {
            Integer i = ps.getOrDefault(c, 0);
            ps.put(c, i + 1);
        }
        Map<Character, Integer> cur = new HashMap();
        cur.putAll(ps);
        List<Integer> ret = new ArrayList<>();
        int start = 0;
        int begin = -1;
        while (start < s.length()) {
            char c = s.charAt(start);
            if (!p.contains(String.valueOf(c))) {
                begin = -1;
                cur.clear();
                cur.putAll(ps);
                start++;
            } else {
                int curI = cur.getOrDefault(c, 0);
                curI--;
                cur.put(c, curI);
                if (curI < 0) {
                    while (begin < start) {
                        char cb = s.charAt(begin);
                        int val = cur.getOrDefault(cb, 0) + 1;
                        if (val != 0) {
                            cur.put(cb, val);
                        }else {
                            cur.remove(cb);
                        }
                        begin++;
                        if (cb == c) {
                            break;
                        }
                    }
                } else {
                    if (begin == -1) {
                        begin = start;
                    }
                    if (curI == 0) {
                        cur.remove(c);
                    }
                }

                if (cur.size() == 0) {
                    ret.add(begin);
                    cur.put(s.charAt(begin), 1);
                    begin++;
                }
                start++;
            }
        }
        return ret;
    }
}
