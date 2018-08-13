package com.zcc.puzzle.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * "tree"
     * <p>
     * Output:
     * "eert"
     * <p>
     * Explanation:
     * 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     * <p>
     * Input:
     * "cccaaa"
     * <p>
     * Output:
     * "cccaaa"
     * <p>
     * Explanation:
     * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     * <p>
     * Input:
     * "Aabb"
     * <p>
     * Output:
     * "bbAa"
     * <p>
     * Explanation:
     * "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     */
    public static String frequencySort(String s) {
        if (s == null || s.length() < 2) return s;
        final Map<Character, Integer> map = new HashMap<>(52);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer nubm = map.get(c);
            if (nubm == null) {
                map.put(c, 1);
            } else {
                nubm++;
                map.put(c, nubm);
            }
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(s.length(), new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return - map.get(lhs.charAt(0)) + map.get(rhs.charAt(0));
            }
        });
        for (Character c : map.keySet()) {
            int numb = map.get(c);
            StringBuilder stringBuilder = new StringBuilder(numb);
            for (int ii = 0; ii < numb; ii++) {
                stringBuilder.append(c);
            }
            priorityQueue.add(stringBuilder.toString());
        }
        StringBuilder ret = new StringBuilder();
        while (priorityQueue.size() > 0) {
            ret.append(priorityQueue.poll());
        }

        return ret.toString();
    }

    public static void main(String[] args) {

    }

}
