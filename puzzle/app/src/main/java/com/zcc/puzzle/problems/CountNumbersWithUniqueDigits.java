package com.zcc.puzzle.problems;

public class CountNumbersWithUniqueDigits {
    /**
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     * <p>
     * Example:
     * <p>
     * Input: 2
     * Output: 91
     * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
     * excluding 11,22,33,44,55,66,77,88,99
     */

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int count = 10;
        for (int i = 2; i <= n && i <= 10; i++) {
            int vv = 1;
            for (int ii = 0; ii < i - 1; ii++) {
                vv *= (9 - ii);
            }
            count = count + 9 * vv;
        }
        return count;
    }
}
