package com.zcc.puzzle.problems;

public class IsSubSequence {

    public boolean solve(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() < s.length()) return false;
        int p = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(p)) {
                p++;
                if (p == s.length()) return true;
            }
        }
        return p == s.length();

    }
}
