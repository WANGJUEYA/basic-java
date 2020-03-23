package com.jue.java.learntest.leetcode.solution1155;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).numRollsToTarget(1, 6, 3));
        System.out.println((new Solution()).numRollsToTarget(2, 6, 7));
        System.out.println((new Solution()).numRollsToTarget(2, 5, 10));
        System.out.println((new Solution()).numRollsToTarget(1, 2, 3));
        System.out.println((new Solution()).numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int d, int f, int target) {
        double MOD = 1E9 + 7;
        int[] base = new int[f + 1], newest;
        for (int j = 1; j <= f; j++) {
            base[j] = 1;
        }
        for (int i = 2; i <= d; i++) {
            int len = i * f + 1;
            newest = new int[len];
            for (int j = 1; j < len; j++) {
                int sum = 0;
                for (int begin = Math.max(1, j - f), end = Math.min((i - 1) * f, j - 1); begin <= end; begin++) {
                    sum = (int) ((sum + base[begin]) % MOD);
                }
                newest[j] = sum;
            }
            base = Arrays.copyOf(newest, len);
        }
        return (target < 0 || target >= base.length) ? 0 : base[target]; // 边界条件
    }
}