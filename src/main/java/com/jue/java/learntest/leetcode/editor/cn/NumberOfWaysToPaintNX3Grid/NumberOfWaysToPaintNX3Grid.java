//你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜
//色不同）。 
//
// 给你网格图的行数 n 。 
//
// 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：12
//解释：总共有 12 种可行的方法：
//
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：54
// 
//
// 示例 3： 
//
// 输入：n = 3
//输出：246
// 
//
// 示例 4： 
//
// 输入：n = 7
//输出：106494
// 
//
// 示例 5： 
//
// 输入：n = 5000
//输出：30228214
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// grid[i].length == 3 
// 1 <= n <= 5000 
// 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.NumberOfWaysToPaintNX3Grid;

/**
 * @author JUE
 * @number 1411
 */
public class NumberOfWaysToPaintNX3Grid {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
