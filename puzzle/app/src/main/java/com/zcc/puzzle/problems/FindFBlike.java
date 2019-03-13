package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class FindFBlike {


    public static void main(String[] args) {
        FindFBlike findFBlike = new FindFBlike();
        List result = findFBlike.splitIntoFibonacci("17522");
        System.out.print(result);
    }

    List<Integer> ret = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() < 3) {
            return ret;
        }
        int i = 1;
        while (i <= S.length() - i) {
            if (S.charAt(0) == '0') {
                ret.add(0);
                boolean result = checkSec(S, 0, 1);
                if (!result) {
                    ret.clear();
                }
                return ret;
            } else {
                try {
                    int val = Integer.valueOf(S.substring(0, i));
                    ret.add(val);
                    boolean result = checkSec(S, val, i);
                    if (!result) {
                        ret.remove(ret.size() - 1);
                    } else {
                        return ret;
                    }
                } catch (NumberFormatException e) {
                    return ret;
                }
            }
            i++;
        }
        return ret;
    }

    public boolean check(String S, int pre1, int pre2, int startPos) {
        if (startPos == S.length()) return true;
        int i = startPos + 1;
        while (i <= S.length()) {
            if (S.charAt(startPos) == '0') {
                if (pre1 + pre2 == 0) {
                    ret.add(0);
                    boolean result = check(S, pre2, 0, startPos + 1);
                    if (result) {
                        return true;
                    } else {
                        ret.remove(ret.size() - 1);
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                try {
                    int val = Integer.valueOf(S.substring(startPos, i));
                    if (pre1 + pre2 == val) {
                        ret.add(val);
                        boolean result = check(S, pre2, val, i);
                        if (!result) {
                            ret.remove(ret.size() - 1);
                        } else {
                            return true;
                        }
                    } else if (pre1 + pre2 < val) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            i++;
        }
        return false;
    }

    public boolean checkSec(String S, int pre1, int startPos) {
        int i = startPos + 1;
        while (i - startPos <= S.length() - startPos - (i - startPos)) {
            if (S.charAt(startPos) == '0') {
                ret.add(0);
                boolean result = check(S, pre1, 0, startPos + 1);
                if (!result) {
                    ret.remove(ret.size() - 1);
                    return false;
                } else {
                    return true;
                }
            } else {
                try {
                    int val = Integer.valueOf(S.substring(startPos, i));
                    ret.add(val);
                    boolean result = check(S, pre1, val, i);
                    if (!result) {
                        ret.remove(ret.size() - 1);
                    } else {
                        return true;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            i++;
        }
        return false;
    }
}
