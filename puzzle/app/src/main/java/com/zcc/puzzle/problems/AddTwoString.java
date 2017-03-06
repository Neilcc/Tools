package com.zcc.puzzle.problems;

/**
 * Created by Hengyun on 01/03/2017.
 */

public class AddTwoString {

    public static String add(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int diff = a.length() - b.length();
        if (diff > 0) {
            for (int k = 0; k < diff; k++) {
                b = '0' + b;
            }
        } else {
            for (int k = 0; k < -diff; k++) {
                a = '0' + a;
            }
        }
        int i = a.length() - 1;
        String result = "";
        char c = '0';
        while (i > -1) {
            String temp = addChars(a.charAt(i), b.charAt(i), c);
            if (temp.length() > 1) {
                c = '1';
            } else {
                c = '0';
            }
            result = temp.charAt(temp.length() - 1) + result;
            i--;
            if (i < 0 && c == '1') {
                result = '1' + result;
            }
        }
        return result;
    }


    private static String addChars(char a, char b, char c) {
        return "" + ((int) a + (int) b + (int) c - 3 * (int) '0');
    }
}
