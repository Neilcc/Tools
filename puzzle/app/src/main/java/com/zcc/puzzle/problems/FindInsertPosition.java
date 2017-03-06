package com.zcc.puzzle.problems;

/**
 * Created by Hengyun on 02/03/2017.
 */

public class FindInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        return searchPart(nums, target, 0, nums.length - 1);
    }

    public int searchPart(int[] nums, int target, int start, int ends) {
        if (start >= ends) return ends;
        int middle = (ends + start) / 2 ;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return searchPart(nums, target, start, middle-1);
        } else {
            return searchPart(nums, target, middle+1, ends);
        }
    }
}
