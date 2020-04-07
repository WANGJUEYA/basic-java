package com.jue.java.learntest.leetcode.solution0764;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<String> array = new HashSet<>();
        for (int[] m : mines) {
            array.add(m[0] + "," + m[1]);
        }
        int[][][] dp = new int[N][N][4]; // 分别存储 左(i++,j++) 上(i++,j++) 右(i--,j--)  下(i--,j--)

        int index1 = 0, index2, i1 = 0, i2 = N - 1, j1, j2;
        int max = 0;
        while (index1 < N) {
            index2 = 0;
            j1 = 0;
            j2 = N - 1;
            while (index2 < N) {
                if (!array.contains(i1 + "," + j1)) {
                    // 左
                    dp[i1][j1][0] = j1 == 0 ? 1 : dp[i1][j1 - 1][0] + 1;
                    // 上
                    dp[i1][j1][1] = i1 == 0 ? 1 : dp[i1 - 1][j1][1] + 1;
                    max = Math.max(max, Math.min(dp[i1][j1][0], Math.min(dp[i1][j1][1], Math.min(dp[i1][j1][2], dp[i1][j1][3]))));
                }
                if (!array.contains(i2 + "," + j2)) {
                    // 右
                    dp[i2][j2][2] = j2 == N - 1 ? 1 : dp[i2][j2 + 1][2] + 1;
                    // 下
                    dp[i2][j2][3] = i2 == N - 1 ? 1 : dp[i2 + 1][j2][3] + 1;
                    max = Math.max(max, Math.min(dp[i2][j2][0], Math.min(dp[i2][j2][1], Math.min(dp[i2][j2][2], dp[i2][j2][3]))));
                }

                j1++;
                j2--;
                index2++;
            }
            i1++;
            i2--;
            index1++;
        }
        return max;
    }
}