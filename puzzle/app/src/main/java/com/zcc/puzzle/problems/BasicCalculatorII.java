package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cc on 2019-10-22.
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("14/3-2"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        ArrayList<String> words = new ArrayList<>();
        s = s.replace(" ", "");
        char[] sb = s.toCharArray();
        String curNum = "";
        for (char c : sb) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                words.add(curNum);
                words.add(c + "");
                curNum = "";
            } else {
                curNum = curNum + c;
            }
        }
        if (!curNum.isEmpty()) {
            words.add(curNum);
        }
        Deque<String> vals = new LinkedList<>();
        for (int i = 0; i < words.size(); i++) {
            String c = words.get(i);
            if (c.equals("*")) {
                String before = vals.pop();
                i++;
                String next = words.get(i);
                long val = Long.valueOf(before) * Long.valueOf(next + "");
                vals.push(String.valueOf(val));
            } else if (c.equals("/")) {
                String before = vals.pop();
                i++;
                String next = words.get(i);
                long val = Long.valueOf(before) / Long.valueOf(next + "");
                vals.push(String.valueOf(val));
            } else if (c.equals("+") || c.equals("-")) {
                vals.push(c + "");
            } else {
                vals.push(c);
            }
        }

        long val = Long.parseLong(vals.removeLast());
        while (vals.size() > 0) {
            String oper = vals.removeLast();
            long val2 = Long.parseLong(vals.removeLast());
            if ("-".equals(oper)) {
                val -= val2;
            } else {
                val += val2;
            }
        }
        return (int) val;
    }
}
