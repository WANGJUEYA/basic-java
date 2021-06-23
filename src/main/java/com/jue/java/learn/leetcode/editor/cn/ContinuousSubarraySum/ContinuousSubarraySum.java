//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数学 动态规划 
// 👍 257 👎 0


package com.jue.java.learn.leetcode.editor.cn.ContinuousSubarraySum;

/**
 * @author JUE
 * @number 523
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 13));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
//        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 同余定理 哈希表 简化前缀和
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_TimeOut {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 动态规划
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        if (len == 2) {
            return (nums[0] + nums[1]) % k == 0;
        }
        // 如果把数据全部存储会超出容量限制, 故只留一条(fixme 空间优化了时间会超时?)
        int[] dp = new int[0];
        for (int index = 1; index < len; index++) {
            int[] dpNew = new int[index];
            for (int j = 0; j < index; j++) {
                dpNew[j] = nums[index] + (j == 0 ? nums[index - 1] : dp[j - 1]);
                if (dpNew[j] % k == 0) {
                    return true;
                }
            }
            dp = dpNew;
        }
        return false;
    }
}
