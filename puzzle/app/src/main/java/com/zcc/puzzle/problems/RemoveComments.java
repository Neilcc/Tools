package com.zcc.puzzle.problems;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public static void main(String[] args) {
        String[] in = new String[]{"a/*comment", "line", "more_comment*/b"};
        List<String> out = removeComments(in);
    }

    public static List<String> removeComments(String[] source) {
        List<String> ret = new ArrayList();
        char pre = ' ';
        boolean beginDel = false;
        StringBuilder sb = new StringBuilder();
        for (String ss : source) {
            for (char i : ss.toCharArray()) {
                if (i == '/') {
                    if (pre == '/' && !beginDel) {
                        pre = ' ';
                        if (sb.length() > 0)
                            sb.deleteCharAt(sb.length() - 1);
                        break;
                    } else if (pre == '*' && beginDel) {
                        beginDel = false;
                        pre = ' ';
                        continue;
                    } else {
                        if (!beginDel) {
                            sb.append(i);
                        }
                    }
                } else if (i == '*') {
                    if (pre == '/' && !beginDel) {
                        beginDel = true;
                        if (sb.length() > 0)
                            sb.deleteCharAt(sb.length() - 1);
                        pre = ' ';
                        continue;
                    } else {
                        if (!beginDel) {
                            sb.append(i);
                        }
                    }
                } else {
                    if (!beginDel) {
                        sb.append(i);
                    }
                }
                pre = i;
            }
            if (!beginDel) {
                String news = sb.toString();
                if (news.length() > 0) {
                    ret.add(news);
                }
                sb = new StringBuilder();
            }
            pre = ' ';
        }
        return ret;
    }


}
