package com.zcc.puzzle.problems;

import java.util.Arrays;

public class ShipPackages {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int[] sums = new int[weights.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            sums[i] = sum;
        }
        System.out.println(binarySearch(sums[0], sums[sums.length - 1], sums, D));
        return  -1;
    }

    public int binarySearch(int start, int end, int[] sums, int D) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (canDo(sums, D, start)) {
                return start;
            } else {
                return -1;
            }
        }
        int i = (start + end) / 2;
        if (canDo(sums, D, i)) {
            int val = binarySearch(start, i - 1, sums, D);
            if (val > -1) {
                return val;
            } else {
                return i;
            }
        } else {
            return binarySearch(i + 1, end, sums, D);
        }
    }


    public boolean canDo(int[] sums, int D, int amount) {
        int count = 0;
        int last = 0;
        int lastI = 0;
        while (lastI < sums.length) {
            int target = last + amount;
            int index = Arrays.binarySearch(sums, lastI, sums.length, target);
            if (index >= lastI) {
                count++;
                last = sums[index];
                lastI = index + 1;
            } else if (index < 0) {
                index = -index - 1;
                if(index == lastI){
                    return false;
                }
                count++;
                last = sums[index - 1];
                lastI = index;
            }
        }
        return count <= D;
    }

    public static void main(String[] args) {
        ShipPackages shipPackages = new ShipPackages();
        shipPackages.shipWithinDays(new int[]{
                1, 2, 3,4,5,6,7,8,9,10
        }, 5);
    }
}
