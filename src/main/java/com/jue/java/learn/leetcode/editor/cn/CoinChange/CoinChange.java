//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package com.jue.java.learn.leetcode.editor.cn.CoinChange;

import java.util.Arrays;

/**
 * @author JUE
 * @number 322
 */
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 100));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{2}, 1));
        System.out.println(solution.coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        // 注意: 所有为0的值实际上都是-1
        for (int index = 0; index <= amount; index++) {
            int min = -1;
            for (int c : coins) {
                int temp = -1;
                if (index == c) {
                    temp = 1;
                }
                if (index > c) {
                    if (dp[index - c] != -1) {
                        temp = dp[index - c] + 1;
                    }
                }
                if (temp != -1) {
                    min = min == -1 ? temp : Math.min(min, temp);
                }
            }
            dp[index] = min;
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_TimeOut {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeSort(coins, amount);
    }

    public int coinChangeSort(int[] coins, int amount) {
        // 假定硬币是排好序的(对硬币排序)
        if (amount == 0) {
            return 0;
        }
        // 先最大的
        int len = coins.length;
        if (len == 0) {
            return -1;
        }
        int sub = amount % coins[len - 1];
        int count = amount / coins[len - 1];
        if (sub == 0) {
            return count;
        }
        int min = -1;
        while (count >= 0) {
            int temp = coinChange(Arrays.copyOf(coins, len - 1), sub);
            if (temp != -1) {
                // 此处并不能果断判断越大越好
                min = min == -1 ? count + temp : Math.min(min, count + temp);
            }
            count--;
            sub += coins[len - 1];
        }
        return min;
    }
}
