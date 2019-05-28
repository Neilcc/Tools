package com.zcc.puzzle.problems;

import java.util.ArrayList;

public class MiniStack {
    private ArrayList<Integer> stack = new ArrayList<>();
    private ArrayList<Integer> minIndexs = new ArrayList<>();

    /**
     * initialize your data structure here.
     *  最优做法是栈内间隔存， 即  min0~0, val0,  min0~1,  va1, min 0~2, val2, min0~3, val3
     *   如此一来 最小值 则是-2 index 的值， 需要注意的是 每次push 需要对比当前与之前的最小值， 决定这一次的二层结构的min 0～ n 的值
     *   记录以前的值，像不像动态规划。
     */
    public MiniStack() {

    }

    public static void main(String[] args) {
        MiniStack miniStack = new MiniStack();
        miniStack.push(-2);
        miniStack.push(0);
        miniStack.push(-3);
        int val = miniStack.getMin();
        miniStack.pop();
        miniStack.top();
        miniStack.getMin();
    }

    public void push(int x) {
        stack.add(x);
        boolean inserted = false;
        for (int i = 0; i < minIndexs.size(); i++) {
            int val = stack.get(minIndexs.get(i));
            if (x < val) {
                minIndexs.add(i, stack.size() - 1);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            minIndexs.add(stack.size() - 1);
        }
    }

    public void pop() {
        if (stack.size() == 0)
            return;
        int index = stack.size() - 1;
        stack.remove(index);
        minIndexs.remove((Integer) index);
    }

    public int top() {
        if (stack.size() == 0)
            return 0;
        int index = stack.size() - 1;
        int val = stack.get(index);
        return val;
    }

    public int getMin() {
        if (stack.size() == 0) return 0;
        int index = minIndexs.get(0);
        int val = stack.get(index);
        return val;
    }
}