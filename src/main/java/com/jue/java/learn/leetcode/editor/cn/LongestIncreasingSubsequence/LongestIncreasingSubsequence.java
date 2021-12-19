//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划


package com.jue.java.learn.leetcode.editor.cn.LongestIncreasingSubsequence;

/**
 * @author JUE
 * @number 300
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{0}));
        System.out.println(solution.lengthOfLIS(new int[]{2, 2}));
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[]{-2, -1}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        // 优化时间复杂度(LIS 算法, 使用二分查找和数组存储最长递增数组)
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] answer = new int[len + 1];
        answer[0] = Integer.MIN_VALUE;
        int maxLen = 0;
        for (int num : nums) {
            // 如果当前数比
            if (num > answer[maxLen]) {
                answer[++maxLen] = num;
            } else {
                int low = 1, high = maxLen - 1, mid;
                // 二分查找法
                boolean find = false;
                while (low <= high) {
                    mid = (low + high) >> 1;
                    // 找到这个数了
                    if (answer[mid] < num && answer[mid + 1] >= num) {
                        find = true;
                        answer[mid + 1] = num;
                        break;
                    }
                    if (answer[mid - 1] < num && answer[mid] >= num) {
                        find = true;
                        answer[mid] = num;
                        break;
                    }
                    if (answer[mid] <= num) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                // 没找到说明这个数最小
                if (!find) {
                    answer[1] = num;
                }
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class SolutionOld {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] answer = new int[nums.length];
        int result = 0;
        for (int index = 0; index < len; index++) {
            int path = 1;
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    path = Math.max(path, answer[j] + 1);
                }
            }
            answer[index] = path;
            result = Math.max(result, path);
        }
        return result;
    }
}
