package com.zcc.puzzle.problems;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    /**
     * 这里采用的计数来判断波段，重点是当时经过一个值，则代表前面的操作归零了，因此里面包含一个0合子串。
     * 采用一个查询表记录经过的每一个索引对应的值，表里面总是记录的最靠前的那个索引，（也就是已经有了就不更新了），
     * 然后遍历一次，如果发现表里面有值了，必然跟前面一个索引的之间存在零合字串，记录最大的，就可以了。
     *
     * @param nums
     * @return
     */

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

}
