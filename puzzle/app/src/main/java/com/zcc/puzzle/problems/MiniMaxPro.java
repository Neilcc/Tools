package com.zcc.puzzle.problems;

/**
 * Created by cc on 2019-12-13.
 */
public class MiniMaxPro {

    public static void main(String[] args) {
        MiniMaxPro miniMaxPro = new MiniMaxPro();
        System.out.println(miniMaxPro.getMoneyAmount2(20));
    }

    public int getMoneyAmount2(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            f[i][i] = 0;
            f[i - 1][i] = i - 1;
        }
        for (int d = 2; d <= n - 1; d++) {
            for (int i = 1; i <= n - d; i++) {
                int minCos = Integer.MAX_VALUE;
                for (int j = i; j <= i + d; j++) {
                    int mCos = j;
                    int leftCos = 0;
                    if (j - 1 > i) {
                        leftCos += f[i][j - 1];
                    }
                    int rightCos = 0;
                    if (j + 1 < i + d) {
                        rightCos += f[j + 1][i + d];
                    }
                    int mm = leftCos > rightCos ? leftCos : rightCos;
                    mCos += mm;
                    if (mCos < minCos) {
                        minCos = mCos;
                    }
                }
                f[i][i + d] = minCos;
            }
        }
        return f[1][n];

    }

    public int getMoneyAmount(int n) {
        // cost
        int[] f = new int[n + 1];
        // failed time
        int[] g = new int[n + 1];
        f[0] = 0;
        g[0] = 0;
        f[1] = 0;
        g[1] = 0;
        for (int i = 2; i <= n; i++) {
            // guess from i - > 1
            int bestCost = Integer.MAX_VALUE;
            int bestCount = 0;
            for (int j = i; j >= 1; j--) {
                // worest case:
                // left case
                int case1 = 0;
                int failedCount1 = 0;
                if (j - 1 > 0) {
                    case1 += j + f[j - 1];
                    failedCount1 = 1 + g[j - 1];
                }
                // right case
                int case2 = 0;
                int failedCount2 = 0;
                if (j + 1 <= i) {
                    int len = i - j;
                    int bias = j;
                    int failedCount = g[len];
                    case2 += j + failedCount * bias + f[len];
                    failedCount2 = 1 + failedCount;
                }
                // most cost between l and r;
                int mW = 0;
                int mC = 0;
                if (case1 > case2) {
                    mW = case1;
                    mC = failedCount1;
                } else if (case1 < case2) {
                    mW = case2;
                    mC = failedCount2;
                } else {
                    mW = case1;
                    // 这里有个疑问，当花销一致的时候， 那个步长越多 因为可能影响下一个 迭代的右边的计算。 也被认为花销越多 是否合适。
                    // 从test case 来看其实是不合适的
                    // 这里有个证明问题 就是右侧区间 x ~ y  的f 值是不是一定等于  f [y-x] + (x-1) * exchange time;这里似乎不是很好证明。
                    // 因为 需要f 最小的它 还引入了一个交换次数作为加成，这样来看 某写情况会让 f y-x 大的值 反而出现。
                    // 还是需要二维的方法。也可以验证一下 f x~ y  =  f(1 ~ y-1) + count * extime; 从test case来看肯定是不对的。

                    mC = failedCount1 > failedCount2 ? failedCount1 : failedCount2;
                }
                if (mW < bestCost) {
                    bestCost = mW;
                    bestCount = mC;
                } else if (mW == bestCost) {
                    bestCost = mW;
                    bestCount = mC > bestCount ? mC : bestCount;
                }
            }
            f[i] = bestCost;
            g[i] = bestCount;
        }
        return f[n];
    }
}
