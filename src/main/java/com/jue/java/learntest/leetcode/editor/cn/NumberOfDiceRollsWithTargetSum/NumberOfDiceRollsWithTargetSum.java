//这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。 
//
// 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。 
//
// 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：d = 1, f = 6, target = 3
//输出：1
// 
//
// 示例 2： 
//
// 输入：d = 2, f = 6, target = 7
//输出：6
// 
//
// 示例 3： 
//
// 输入：d = 2, f = 5, target = 10
//输出：1
// 
//
// 示例 4： 
//
// 输入：d = 1, f = 2, target = 3
//输出：0
// 
//
// 示例 5： 
//
// 输入：d = 30, f = 30, target = 500
//输出：222616187 
//
// 
//
// 提示： 
//
// 
// 1 <= d, f <= 30 
// 1 <= target <= 1000 
// 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.NumberOfDiceRollsWithTargetSum;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1155
 */
public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRollsToTarget(1, 6, 3));
        System.out.println(solution.numRollsToTarget(2, 6, 7));
        System.out.println(solution.numRollsToTarget(2, 5, 10));
        System.out.println(solution.numRollsToTarget(1, 2, 3));
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
