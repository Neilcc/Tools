package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        List<List<Integer>> markList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String target = strs[i];
            List<Integer> mark = getKey(target);
            boolean isOk = false;
            for (int j = 0; j < lists.size(); j++) {
                if (lists.get(j).get(0).length() == target.length()) {
                    List<Integer> marKR = markList.get(j);
                    if (markList.get(j) == null && mark == null) {
                        lists.get(j).add(target);
                        isOk = true;
                        break;
                    } else {
                        boolean isOkT = true;
                        for (int k = 0; k < mark.size(); k++) {
                            if (!mark.get(k).equals(marKR.get(k))) {
                                isOkT = false;
                                break;
                            }
                        }
                        if (isOkT) {
                            isOk = true;
                            lists.get(j).add(target);
                            break;
                        }
                    }
//                    if (markList.get(j) == mark) {
//                        lists.get(j).add(target);
//                        isOk = true;
//                        break;
//                    }
                }

            }
            if (!isOk) {
                List<String> newlist = new ArrayList<>();
                newlist.add(target);
                lists.add(newlist);
                markList.add(mark);
            }
        }
        return lists;
    }

    public List<Integer> getKey(String s) {
        if (s == null) return null;
        if (s.length() == 0) return new ArrayList<>();
        List<Integer> mark = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            mark.add(0);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ii = mark.get(c - 'a') + 1;
            mark.set(c - 'a', ii);
        }
        return mark;
    }

    // 用素数编码, 每个素数标志一个字母，一共26个，由于素数的n次方累加之后也是互异的值，因此可以用n次方编码字母出现次数 这样比一个int 的32 位编码多了次数记录的功能
    // 同时mark 值用map 存，这样可以直接索引。
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char ch : s.toCharArray()) {
                key *= prime[ch - 'a'];
            }
            List<String> tmp;
            if (index.containsKey(key)) {
                tmp = ans.get(index.get(key));
                tmp.add(s);
            } else {
                tmp = new ArrayList<String>();
                index.put(key, ans.size());
                tmp.add(s);
                ans.add(tmp);
            }
        }
        return ans;

    }

    //还有一种方式是用排序后的string 编码，这样直接通过map索引'

    // 本例 我陷入了 比特编码的困境，最后发现要次数记录的同时 仍然使用比特编码 变成了int 数组，最终陷入困境。
    // 另外没有用到编码标志的直接索引的优化，降低了速度

}
