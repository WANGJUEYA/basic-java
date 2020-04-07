package com.jue.java.learntest.leetcode.solution1395;

/**
 * @author JUE
 * @date 2020/3/29
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).numTeams(new int[]{1, 2, 3, 4, 5}));
        System.out.println((new Solution()).numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println((new Solution()).numTeams(new int[]{3, 6, 7, 5, 1}));
    }

    public int numTeams(int[] rating) {
        int len = rating.length;
        if (len <= 2) {
            return 0;
        }
        int sum = 0;
        // 计算比几个数大或者小
        int[][] dp = new int[2][len];
        for (int i = 0; i < len; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < i; j++) {
                // 递增
                if (rating[i] > rating[j]) {
                    count1++;
                    sum += dp[0][j];
                }

                // 递减
                if (rating[i] < rating[j]) {
                    count2++;
                    sum += dp[1][j];
                }
            }
            dp[0][i] = count1;
            dp[1][i] = count2;

//            System.out.println(Arrays.toString(dp[1]));
        }
        return sum;
    }
}
