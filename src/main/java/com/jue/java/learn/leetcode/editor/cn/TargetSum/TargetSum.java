//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1933 👎 0


package com.jue.java.learn.leetcode.editor.cn.TargetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 494
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{0, 0, 1}, 1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(nums[0], 1);
        dp.put(-nums[0], dp.getOrDefault(-nums[0], 0) + 1);
        for (int i = 1, len = nums.length; i < len; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            int finalI = i;
            dp.forEach((k, v) -> {
                newDp.put(k + nums[finalI], newDp.getOrDefault(k + nums[finalI], 0) + v);
                newDp.put(k - nums[finalI], newDp.getOrDefault(k - nums[finalI], 0) + v);
            });
            dp = newDp;
        }
        return dp.getOrDefault(target, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
