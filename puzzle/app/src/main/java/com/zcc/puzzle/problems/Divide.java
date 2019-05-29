package com.zcc.puzzle.problems;

import java.util.ArrayList;

public class Divide {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "NaN";
        boolean positive = ((numerator * 1.0) * denominator) > 0;
        long numer = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        if (numer >= deno) {
            long val = numer / deno;
            long delta = numer % deno;
            sb.append(val);
            numer = delta;
            if (delta == 0)
                return (positive ? "" : "-") +sb.toString();
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        sb.append(".");
        int afterDot = sb.length();
        ArrayList<Long> delta = new ArrayList<>();
        numer *= 10;
        while (!delta.contains(numer)) {
            if (numer < deno) {
                delta.add(numer);
                numer *= 10;
                sb.append("0");
            } else if (numer == deno) {
                sb.append("1");
                return (positive ? "" : "-") + sb.toString();
            } else {
                delta.add(numer);
                long val = numer / deno;
                long dd = numer % deno;
                sb.append(val);
                numer = dd * 10;
                if (dd == 0) {
                    return (positive ? "" : "-") + sb.toString();
                }
            }
        }
        int ii = delta.indexOf((Long) numer);
        sb.append(")");
        sb.insert(afterDot + ii, "(");
        return (positive ? "" : "-") + sb.toString();
    }

    public static void main(String[] args) {
        Divide d = new Divide();
        d.fractionToDecimal(-2147483648, 1);
    }
}
