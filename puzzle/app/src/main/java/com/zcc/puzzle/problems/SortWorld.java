package com.zcc.puzzle.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class SortWorld {
    /**
     *  这个方式是通过排序和栈来完成，逻辑比较复杂不够明显，事实上 字典树这个数据结构完美诠释了下述的过程。
     * @param args
     */
    public static void main(String[] args) {
        String[] word = new String[]{
                "rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"
        };
        String rest = sortLex(word);
        for (String s : word)
            System.out.print(s + "\n");

        System.out.print("\n" + rest);
    }

    public static String sortLex(String[] words) {
        if (words == null || words.length == 0) return "";
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                for (; i < o1.length() && i < o2.length(); i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if (c1 == c2) {
                        continue;
                    } else {
                        return c1 - c2;
                    }
                }
                return o1.length() - o2.length();

            }
        });
        String max = words[0];
        Stack<String> record = new Stack();
        for (String s : words) {
            if (record.size() == 0) {
                if (s.length() == 1) {
                    record.push(s);
                }
                continue;
            }
            String ss = record.peek();
            if (ss.length() == s.length() - 1) {
                if (s.contains(ss)) {
                    record.push(s);
                    if (s.length() > max.length()) {
                        max = s;
                    }
                }
            } else {
                String sss = ss;
                while (record.size() > 0 && sss.length() >= s.length()) {
                    record.pop();
                    if (record.size() == 0) {
                        break;
                    }
                    sss = record.peek();
                }
                if (record.size() == 0) {
                    if (s.length() == 1) {
                        record.push(s);
                    }
                } else {
                    if (sss.length() + 1 == s.length()) {
                        if (s.contains(sss)) {
                            record.push(s);
                            if (s.length() > max.length()) {
                                max = s;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
