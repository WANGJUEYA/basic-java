//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 
//true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
// Related Topics 贪心 数组 👍 475 👎 0


package com.jue.java.learn.leetcode.editor.cn.IncreasingTripletSubsequence;

/**
 * @author JUE
 * @number 334
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(solution.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // true
        System.out.println(solution.increasingTriplet(new int[]{6, 7, 1, 2})); // false
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 动态规划法; 如果比前一个大, 放置于后方, 如果没有前面一个大, 则找到比他小的位置进行替换
        int[] three = new int[3];
        three[0] = nums[0];
        int last = 0;
        for (int index = 1, len = nums.length; index < len; index++) {
            if (nums[index] > three[last]) {
                three[++last] = nums[index];
                if (last == 2) {
                    return true;
                }
            } else {
                if (nums[index] < three[0]) {
                    three[0] = nums[index];
                }
                if (last == 1 && nums[index] > three[0]) {
                    three[1] = nums[index];
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
