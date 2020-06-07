//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.HouseRobberIi;

/**
 * @author JUE
 * @number 213
 */
public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int preMax = 0;
        int currentMax = 0;
        int[] count = new int[len - 1];
        for (int index = 0; index < len - 1; index++) {
            currentMax = Math.max(currentMax, (count[index]) = preMax + nums[index]);
            preMax = index - 1 >= 0 ? Math.max(preMax, count[index - 1]) : preMax;
        }

        preMax = 0;
        int currentMax1 = 0;
        count = new int[len];
        for (int index = 1; index < len; index++) {
            currentMax1 = Math.max(currentMax1, (count[index]) = preMax + nums[index]);
            preMax = Math.max(preMax, count[index - 1]);
        }

        return Math.max(currentMax, currentMax1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
