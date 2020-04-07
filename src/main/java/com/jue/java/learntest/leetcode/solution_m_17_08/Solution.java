package com.jue.java.learntest.leetcode.solution_m_17_08;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] h = {8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773};
        int[] w = {9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340};
        int[] h1 = {2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181};
        int[] w1 = {5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594};
        System.out.println((new Solution()).bestSeqAtIndex(h1, w1));
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        if (len <= 0) {
            return 0;
        }
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        Arrays.sort(person, (a, b) -> (a[0] - b[0]) * 10000 + (b[1] - a[1]));
        int max = 0;
        int[] dp = new int[len + 1]; // 盛放最优的最长增序列
        for (int index = 0; index < len; index++) {
            int i = 0, j = max, mid = (i + j) / 2;
            int that = person[index][1];
            // 二分查找法
            while (i < j) {
                if (dp[mid] < that) {
                    i = mid + 1;
                } else if (dp[mid] > that) {
                    j = mid - 1;
                } else {
                    i = mid;
                    j = mid;
                }
                mid = (i + j) / 2;
            }
            if (dp[mid] < that) {
                if (mid + 1 > max) {
                    max = mid + 1;
                    dp[max] = that;
                } else {
                    dp[mid + 1] = Math.min(dp[mid + 1], that);
                }
            } else if (dp[mid] > that) {
                dp[mid] = Math.min(dp[mid], that);
            }
//            System.out.println(Arrays.toString(dp));
        }
        return max;
    }
}