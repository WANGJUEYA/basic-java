//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.NumberOfLongestIncreasingSubsequence;

/**
 * @author JUE
 * @number 673
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 3, 5, 4, 7};
        int[] array1 = new int[]{2, 2, 2, 2, 2};
        int[] array2 = new int[]{2, 3, 3, 3, 3};
        int[] array3 = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        int[] array4 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(solution.findNumberOfLIS(array4));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] size = new int[len]; // 用于记录每个位置的长度(最长)
        int[] count = new int[len]; // 用于计数每种长度的个数

        int maxSize = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            int thisSize = 1;
            int thisCount = 1;
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    if (size[j] + 1 > thisSize) {
                        thisSize = size[j] + 1;
                        thisCount = count[j];
                    } else if (size[j] + 1 == thisSize) {
                        thisCount += count[j];
                    }
                }
            }
            maxSize = Math.max(maxSize, thisSize);
            size[index] = thisSize;
            count[index] = thisCount;
        }
        int result = 0;
        for (int index = 0; index < len; index++) {
            if (size[index] == maxSize) {
                result += count[index];
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
