package com.zcc.puzzle.problems;

import java.util.Arrays;

public class HandOfStraights {
    // 简化逻辑的方法是找个哈希表存着 然后一个一个算 不过那样空间复杂度比较高 时间复杂度差不多
    public static int[] in = new int[]{
            1, 2, 3, 6, 2, 3, 4, 7, 8
    };


    public static void main(String[] args) {
        isNStraightHand(in, 3);
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length < W) return false;
        if (W == 0 || W == 1) return true;
        if (hand.length % W != 0) return false;
        Arrays.sort(hand);
        int curVal = hand[0];
        int count = 1;
        int[] valueCount = new int[W];
        int curNumberIndex = 0;
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] == curVal) {
                count++;
            } else if (hand[i] == curVal + 1 || ((hand[i] != curVal + 1) && (curNumberIndex == W - 1))) {
                boolean isInterrupt = false;
                if (curNumberIndex == W - 1 && hand[i] != curVal + 1) {
                    isInterrupt = true;
                }
                curVal = hand[i];
                valueCount[curNumberIndex] = count;
                count = 1;
                curNumberIndex++;
                if (curNumberIndex == W) {
                    int offside = valueCount[0];
                    int delta = 1;
                    boolean inMoving = false;
                    for (int j = 1; j < W; j++) {
                        if (valueCount[j] - offside < 0) {
                            return false;
                        } else if (valueCount[j] - offside == 0) {
                            if (inMoving) return false;
                            delta++;
                        } else {
                            inMoving = true;
                            valueCount[j - delta] = valueCount[j] - offside;
                        }
                    }
                    curNumberIndex = W - delta;
                    if (isInterrupt && curNumberIndex != 0) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        if (curNumberIndex != W - 1) {
            return false;
        } else {
            valueCount[curNumberIndex] = count;
            int t = valueCount[0];
            for (int tt : valueCount) {
                if (tt != t) return false;
            }
            return true;
        }
    }

}
