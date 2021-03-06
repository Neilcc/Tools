package com.zcc.puzzle.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosetThreeSUm {

    private int sum = 0;
    private int distance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ClosetThreeSUm closetThreeSUm = new ClosetThreeSUm();
        int[] input = new int[]{
                -55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33
        };
        int ret = closetThreeSUm.threeSumClosest(input, 0);
        System.out.print(closetThreeSUm.sum);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return rhs - lhs;
            }
        });
        q.add(1);
        q.add(3);
        q.add(4);
        q.add(2);
        System.out.print(q.poll());
        System.out.print(q.poll());
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

}
