package com.jue.java.learntest.leetcode.solution1411;

/**
 * @author JUE
 * @date 2020/4/12
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public int numOfWays(int n) {
        if (n <= 0) {
            return 0;
        }
        //数位dp的思想? int[pos][stats][bound] -bound 0中间位置 1
        // 1. 左右同色 3(左右位) * 2(本位置)
        //      -> 左右同色 3
        //      -> 左右异色 2
        // 2. 左右异色 3*2(左右位) * 1(本位置)
        //      -> 左右同色 2
        //      -> 左右异色 2
        int mod = (int) (1E9 + 7);
        long[] dp = new long[2];
        long[] temp;
        dp[0] = 6;
        dp[1] = 6;
        for (int index = 1; index < n; index++) {
            temp = new long[2];
            temp[0] = (dp[0] * 3 + dp[1] * 2) % mod;
            temp[1] = (dp[0] * 2 + dp[1] * 2) % mod;
            dp = temp;
        }

        return (int) (dp[0] + dp[1]) % mod;
    }
}