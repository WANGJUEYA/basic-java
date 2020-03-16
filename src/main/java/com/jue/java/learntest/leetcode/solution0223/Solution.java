package com.jue.java.learntest.leetcode.solution0223;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = ((C - A) * (D - B)) + ((G - E) * (H - F));
        if ((E > A && E > C) || (G < A && G < C) || (F > B && F > D) || (H < B && H < D)) {
            return sum;
        }

        int[] x = {A, C, E, G};
        int[] y = {B, D, F, H};
        Arrays.sort(x);
        Arrays.sort(y);
        return sum - (x[2] - x[1]) * (y[2] - y[1]);
    }
}