package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2019-11-13.
 */
class MyCalendarTwo {

    List<int[]> dates = new ArrayList<int[]>();

    public MyCalendarTwo() {

    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        int[][] in = new int[][]{{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19},
                {3, 14}, {25, 39}, {6, 19}};
        for (int[] ii : in) {
            System.out.println(calendar.book(ii[0], ii[1]));
        }
    }

    public boolean book(int start, int end) {
        if (dates.size() == 0) {
            dates.add(new int[]{start, end, 1});
            return true;
        }
        List<int[]> backup = new ArrayList<>(dates);
        for (int i = 0; i < dates.size(); i++) {
            if (end <= dates.get(i)[0]) {
                dates.add(i, new int[]{start, end, 1});
                return true;
            } else if (start >= dates.get(i)[1]) {
                continue;
            } else {
                // start < i1 || end > i0
                if (dates.get(i)[2] >= 2) {
                    dates = backup;
                    return false;
                } else {
                    int m1, m2;
                    if (start > dates.get(i)[0]) {
                        m1 = dates.get(i)[0];
                        m2 = start;
                    } else {
                        m1 = start;
                        m2 = dates.get(i)[0];
                    }
                    int m3, m4;
                    boolean needJudgeNext = false;
                    if (end > dates.get(i)[1]) {
                        m3 = dates.get(i)[1];
                        m4 = end;
                        needJudgeNext = true;
                    } else {
                        m3 = end;
                        m4 = dates.get(i)[1];
                    }
                    int[] zone1 = new int[]{m1, m2, 1};
                    int[] zone2 = new int[]{m2, m3, 2};
                    int[] zone3 = new int[]{m3, m4, 1};
                    dates.remove(i);
                    if (!needJudgeNext && m3 != m4) {
                        dates.add(i, zone3);
                    }
                    dates.add(i, zone2);
                    if (m1 != m2) {
                        dates.add(i, zone1);
                    }
                    if (!needJudgeNext) {
                        return true;
                    } else {
                        start = zone3[0];
                        end = zone3[1];
                    }
                }
            }
        }
        dates.add(new int[]{start, end, 1});
        return true;
    }
}