//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


package com.jue.java.learntest.leetcode.editor.cn.JumpGame;

/**
 * @author JUE
 * @number 55
 */
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[] flag;

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        flag = new boolean[len];
        canJump(nums, 0);
        return flag[len - 1];
    }

    public void canJump(int[] nums, int index) {
        // 如果为true 表示曾经到过, 不需要进行处理
        if (!flag[index]) {
            flag[index] = true;
            // 把所有能到的放入
            for (int num = nums[index]; num > 0; num--) {
                if (index + num < nums.length) {
                    canJump(nums, index + num);
                }
                if (index - num > 0) {
                    canJump(nums, index - num);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
