package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static final String[] DICTIONARY = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        List<String> ret = new ArrayList<>();
        traversal(digits, "", ret);
        return ret;
    }

    public void traversal(String digits, String value, List<String> ret) {
        if (digits.length() == 0) {
            ret.add(value);
            return;
        }
        int val = Integer.parseInt(digits.substring(0, 1));
        String nodes = DICTIONARY[val];
        String rest = digits.substring(1);
        for (char s : nodes.toCharArray()) {
            traversal(rest, value + s, ret);
        }
    }
}
