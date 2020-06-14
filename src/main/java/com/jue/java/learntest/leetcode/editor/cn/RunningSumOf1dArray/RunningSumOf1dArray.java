//给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。 
//
// 请返回 nums 的动态和。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,6,10]
//解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1,1]
//输出：[1,2,3,4,5]
//解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。 
//
// 示例 3： 
//
// 输入：nums = [3,1,2,10,1]
//输出：[3,4,6,16,17]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10^6 <= nums[i] <= 10^6 
// 
// Related Topics 数组


package com.jue.java.learntest.leetcode.editor.cn.RunningSumOf1dArray;

/**
 * @author JUE
 * @number 5436
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        int sum = 0;
        int[] result = new int[len];
        for (int index = 0; index < len; index++) {
            sum += nums[index];
            result[index] = sum;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
