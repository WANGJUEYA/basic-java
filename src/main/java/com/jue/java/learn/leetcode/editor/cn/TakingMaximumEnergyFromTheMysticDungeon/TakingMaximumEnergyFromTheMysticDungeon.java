//在神秘的地牢中，n 个魔法师站成一排。每个魔法师都拥有一个属性，这个属性可以给你提供能量。有些魔法师可能会给你负能量，即从你身上吸取能量。 
//
// 你被施加了一种诅咒，当你从魔法师 i 处吸收能量后，你将被立即传送到魔法师 (i + k) 处。这一过程将重复进行，直到你到达一个不存在 (i + k) 
//的魔法师为止。 
//
// 换句话说，你将选择一个起点，然后以 k 为间隔跳跃，直到到达魔法师序列的末端，在过程中吸收所有的能量。 
//
// 给定一个数组 energy 和一个整数k，返回你能获得的 最大 能量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： energy = [5,2,-10,-5,1], k = 3 
// 
//
// 输出： 3 
//
// 解释：可以从魔法师 1 开始，吸收能量 2 + 1 = 3。 
//
// 示例 2： 
//
// 
// 输入： energy = [-2,-3,-1], k = 2 
// 
//
// 输出： -1 
//
// 解释：可以从魔法师 2 开始，吸收能量 -1。 
//
// 
//
// 提示： 
//
// 
// 1 <= energy.length <= 10⁵ 
// -1000 <= energy[i] <= 1000 
// 1 <= k <= energy.length - 1 
// 
//
// 
//
// 👍 2 👎 0


package com.jue.java.learn.leetcode.editor.cn.TakingMaximumEnergyFromTheMysticDungeon;

/**
 * @author JUE
 * @number 3147
 */
public class TakingMaximumEnergyFromTheMysticDungeon {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        // 尝试动态规划 dp[i] = Math.max(dp[i], dp[i-k] + dp[i]);

        int len = energy.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = energy[i];
            if (i >= k) {
                dp[i] = Math.max(dp[i], dp[i - k] + dp[i]);
            }
        }

        int max = dp[len - k];
        for (int i = len - 1; i > len - k; i--) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
