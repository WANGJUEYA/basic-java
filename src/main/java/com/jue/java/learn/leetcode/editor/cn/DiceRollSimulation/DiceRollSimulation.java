//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 154 👎 0


package com.jue.java.learn.leetcode.editor.cn.DiceRollSimulation;

/**
 * @author JUE
 * @number 1223
 */
public class DiceRollSimulation {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        // dp[i][j] 存储第 `i` 次 透出 `j` 数的序列, j为0表示总序列数
        double[][] dp = new double[n + 1][7];
        dp[0][0] = 1;
        for (int index = 1; index <= n; index++) {
            for (int roll = 1; roll <= 6; roll++) {
                int max = rollMax[roll - 1];
                if (index <= max) {
                    // 随心所欲的扔， 序列数为之前的总和
                    dp[index][roll] = dp[index - 1][0];
                } else {
                    int pos = index - max - 1;
                    // 总数减去连续n个roll的可能性, 即第 index - n 位置处为其他数字的数量
                    dp[index][roll] = (1e9 + 7) + dp[index - 1][0] - (dp[pos][0] - dp[pos][roll]);
                }
                // 计算总数
                dp[index][0] = (dp[index][0] + dp[index][roll]) % (1e9 + 7);
            }
        }
        return (int) (dp[n][0] % (1e9 + 7));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
