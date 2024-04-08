//给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。 
//
// 如果 nums 满足以下条件，那么它是 连续的 ： 
//
// 
// nums 中所有元素都是 互不相同 的。 
// nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。 
// 
//
// 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。 
//
// 请你返回使 nums 连续 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：0
//解释：nums 已经是连续的了。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,5,6]
//输出：1
//解释：一个可能的解是将最后一个元素变为 4 。
//结果数组为 [1,2,3,5,4] ，是连续数组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,10,100,1000]
//输出：3
//解释：一个可能的解是：
//- 将第二个元素变为 2 。
//- 将第三个元素变为 3 。
//- 将第四个元素变为 4 。
//结果数组为 [1,2,3,4] ，是连续数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 80 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumNumberOfOperationsToMakeArrayContinuous;

import java.util.Arrays;

/**
 * @author JUE
 * @number 2009
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minOperations(new int[]{4, 2, 5, 3})); // 0
//        System.out.println(solution.minOperations(new int[]{1, 2, 3, 5, 6})); // 1
//        System.out.println(solution.minOperations(new int[]{1, 10, 100, 1000})); // 3
//        System.out.println(solution.minOperations(new int[]{1, 1, 1, 1})); // 3
        System.out.println(solution.minOperations(new int[]{8, 5, 9, 9, 8, 4})); // 2
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int diff = nums.length - 1;
        int low = 0, height = 1, max = 1, count = 1;
        while (low < diff && height <= diff) {
            // 可能包含重复元素
            if (nums[height] <= nums[low] + diff) {
                if (nums[height] > nums[low] && nums[height] > nums[height - 1]) {
                    count++;
                }
                height++;
            } else {
                max = Math.max(max, count);
                while (low < height) {
                    low++;
                    if (nums[low] > nums[low - 1]) {
                        count--;
                    }
                    if (nums[low] >= nums[height] - diff) {
                        break;
                    }
                }
                if (low == height) {
                    count = 1;
                    height = low + 1;
                }
            }
        }
        max = Math.max(max, count);
        return nums.length - max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
