//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


package com.jue.java.learntest.leetcode.editor.cn.JumpGameIi;

/**
 * @author JUE
 * @number 45
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 2, 3})); // 2
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4})); // 2
        System.out.println(solution.jump(new int[]{1, 2, 1, 1, 1})); // 3
        System.out.println(solution.jump(new int[]{1, 1, 1, 1, 1})); // 4
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_TimeOut {
    // 动态规划 空间复杂度 O(n) 时间复杂度 O(n) ~ O(n2)
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && j <= i + nums[i]; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
