//给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [11,7,2,15]
//输出：2
//解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
//元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
//总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
// 
//
// 示例 2： 
//
// 输入：nums = [-3,3,3,90]
//输出：2
//解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
//由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 排序 👍 5 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountElementsWithStrictlySmallerAndGreaterElements;

/**
 * @author JUE
 * @number 2148
 */
public class CountElementsWithStrictlySmallerAndGreaterElements {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countElements(int[] nums) {
        // 找出最大最小的个数
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minNumber = 0;
        int maxNumber = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
                minNumber = 1;
            } else if (num == min) {
                minNumber++;
            }
            if (num > max) {
                max = num;
                maxNumber = 1;
            } else if (num == max) {
                maxNumber++;
            }
        }
        int result = nums.length - minNumber - maxNumber;
        return Math.max(result, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
