//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
// 题目数据保证答案符合 32 位整数范围。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
//
//
// 示例 2：
//
//
//输入：nums = [9], target = 3
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 1000
// nums 中的所有元素 互不相同
// 1 <= target <= 1000
//
//
//
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
//
// Related Topics 数组 动态规划 👍 953 👎 0


package com.jue.java.learn.leetcode.editor.cn.CombinationSumIv;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 377
 */
public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4)); // 7
        System.out.println(solution.combinationSum4(new int[]{9}, 3)); // 0
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    // 我用的这种方法叫 `记忆化dfs` 官方给的方案是动态规划 dp[i] = sum(dp[[0~target]-num])
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        // 如果数组中包含负数，结果应该为0; 但是数据会无限循环
        if (target < 0) {
            return 0;
        }
        // 由于超时，我们使用缓存
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        // 每个数字可以重复，顺序不同为不同结果；那就是递归求子集了
        int count = 0;
        for (int i : nums) {
            count += combinationSum4(nums, target - i);
        }
        cache.put(target, count);
        return count;
    }
}
//leetcoe submit region end(Prohibit modification and deletion)
