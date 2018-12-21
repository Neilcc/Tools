package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToParenthess {

    public static void main(String[] arg) {
        DifferentWaysToParenthess d = new DifferentWaysToParenthess();
        d.diffWaysToCompute("2*3-4*5");
    }

    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        List<Integer> numbStack = new ArrayList<>();
        List<Character> opStack = new ArrayList<>();
        int low = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                int numb = Integer.parseInt(input.substring(low, i));
                numbStack.add(numb);
                opStack.add(input.charAt(i));
                low = i + 1;
            }
        }
        numbStack.add(Integer.parseInt(input.substring(low, input.length())));
        traversal(ret, numbStack, opStack);
        return ret;
    }

    public void traversal(List<Integer> record, List<Integer> numberStack, List<Character> opList) {
        if (opList.size() == 0) {
            record.add(numberStack.get(0));
            return;
        } else if (opList.size() == 1) {
            record.add(cac(numberStack.get(0), numberStack.get(1), opList.get(0)));
            return;
        } else {
            for (int i = 0; i < numberStack.size() - 1; i++) {
                int result = cac(numberStack.get(i), numberStack.get(i + 1), opList.get(i));
                int a = numberStack.get(i);
                int b = numberStack.get(i + 1);
                char c = opList.get(i);
                numberStack.remove(i);
                numberStack.remove(i);
                numberStack.add(i, result);
                opList.remove(i);
                traversal(record, numberStack, opList);
                numberStack.remove(i);
                numberStack.add(i, b);
                numberStack.add(i, a);
                opList.add(i, c);
            }
        }
    }


    private int cac(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return 0;
        }

    }
}
