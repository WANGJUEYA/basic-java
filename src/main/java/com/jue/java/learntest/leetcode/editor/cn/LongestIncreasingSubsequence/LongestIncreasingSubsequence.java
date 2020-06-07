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


package com.jue.java.learntest.leetcode.editor.cn.LongestIncreasingSubsequence;

/**
 * @author JUE
 * @number 300
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] array1 = {0};
        int[] array2 = {2, 2};
        System.out.println(solution.lengthOfLIS(array));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
