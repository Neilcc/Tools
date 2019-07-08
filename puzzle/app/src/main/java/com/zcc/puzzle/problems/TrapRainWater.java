package com.zcc.puzzle.problems;

public class TrapRainWater {

    public static void main(String[] args) {
        TrapRainWater trapRainWater = new TrapRainWater();
        trapRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int i = 0;
        int j = height.length - 1;
        int count = 0;
        int l = i;
        int r = j;
        count += Math.min(height[l], height[r]) * (r - l - 1);
        boolean ltr = false;
        if (height[i] < height[j]) {
            i++;
            ltr = true;
        } else {
            j--;
            ltr = false;
        }
        while (i < j) {
            if (ltr) {
                if (height[i] < height[l]) {
                    count -= height[i];
                    i++;
                } else {
                    int t = i;
                    count -= height[l];
                    if (height[t] > height[r]) {
                        count += (height[r] - height[l]) * (r - t - 1);
                        ltr = false;
                        j--;
                    } else {
                        count += (height[t] - height[l]) * (r - t - 1);
                        ltr = true;
                        i++;
                    }
                    l = t;
                }
            } else {
                if (height[j] < height[r]) {
                    count -= height[j];
                    j--;
                } else {
                    int t = j;
                    count -= height[r];
                    if (height[t] < height[l]) {
                        count += (height[t] - height[r]) * (t - l - 1);
                        ltr = false;
                        j--;
                    } else {
                        count += (height[l] - height[r]) * (t - l - 1);
                        ltr = true;
                        i++;
                    }
                    r = t;
                }
            }
        }
        return count;
    }
}
