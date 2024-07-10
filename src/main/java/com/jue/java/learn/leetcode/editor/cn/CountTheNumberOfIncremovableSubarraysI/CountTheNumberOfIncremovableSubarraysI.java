//给你一个下标从 0 开始的 正 整数数组 nums 。
//
// 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7]
//中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
//
// 请你返回 nums 中 移除递增 子数组的总数目。
//
// 注意 ，剩余元素为空的数组也视为是递增的。
//
// 子数组 指的是一个数组中一段连续的元素序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：10
//解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和
//[1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
//
//
// 示例 2：
//
//
//输入：nums = [6,5,7,8]
//输出：7
//解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
//nums 中只有这 7 个移除递增子数组。
//
//
// 示例 3：
//
//
//输入：nums = [8,7,6,6]
//输出：3
//解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后
//nums 变为 [6,6] ，它不是严格递增的。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50
// 1 <= nums[i] <= 50
//
//
// Related Topics 数组 双指针 二分查找 枚举 👍 34 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountTheNumberOfIncremovableSubarraysI;

/**
 * @author JUE
 * @number 2970
 */
public class CountTheNumberOfIncremovableSubarraysI {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.incremovableSubarrayCount(new int[]{1, 2, 3, 4})); // 10
//        System.out.println(solution.incremovableSubarrayCount(new int[]{6, 5, 7, 8})); // 7
//        System.out.println(solution.incremovableSubarrayCount(new int[]{8, 7, 6, 6})); // 3
//        System.out.println(solution.incremovableSubarrayCount(new int[]{3, 7, 2})); // 4
        System.out.println(solution.incremovableSubarrayCount(new int[]{3, 5, 3, 5})); // 6
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        // 这道题，怎么能算简单题！！！
        // 按照题目给出的双指针暴力一下
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        // 严格递增
        while (start < len) {
            if (start == len - 1 || nums[start + 1] > nums[start]) {
                start++;
            } else {
                break;
            }
        }
        if (start == len) {
            // 是个严格递增队列 1 2 3 4 删除 4 + 3 + 2 + 1 >> 不能移除空数组
            return (len + 1) * len / 2;
        }
        while (end > start) {
            if (nums[end - 1] < nums[end]) {
                end--;
            } else {
                break;
            }
        }
        // 4,6,5,7,8 中间有一部分不递增 start = 1, end = 2; (start-end)之间的元素是必须删除的
        int leftIndex = start;
        int rightIndex = end;
        // 计算左边可以删除到哪里
        while (nums[leftIndex] >= nums[end]) {
            leftIndex--;
            if (leftIndex < 0) {
                break;
            }
        }
        while (nums[rightIndex] <= nums[start]) {
            rightIndex++;
            if (rightIndex >= len) {
                break;
            }
        }
        // 必须要移除的数据
        int count = 1;
        // 当一定把左边的数据移除，此时右边可以扩展 * 左边可以扩展数据
        count += (leftIndex + 2) * (len - end);
        // 一i你大概要把右边的数据移除
        count += (len - rightIndex + 1) * (start + 1);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
