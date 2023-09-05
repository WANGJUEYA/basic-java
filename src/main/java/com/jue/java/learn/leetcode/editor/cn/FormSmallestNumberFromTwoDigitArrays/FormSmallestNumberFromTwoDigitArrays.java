//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
//
//
// 示例 1：
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
//
//
// 示例 2：
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 9
// 1 <= nums1[i], nums2[i] <= 9
// 每个数组中，元素 互不相同 。
//
//
// Related Topics 数组 哈希表 枚举 👍 27 👎 0


package com.jue.java.learn.leetcode.editor.cn.FormSmallestNumberFromTwoDigitArrays;

import java.util.Arrays;

/**
 * @author JUE
 * @number 2605
 */
public class FormSmallestNumberFromTwoDigitArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        // 先查询是否有重复数字，有则取最小，没有则取两个数组最小数
        int min = Integer.MAX_VALUE;
        int[] count1 = new int[10];
        for (int num : nums1) {
            min = Math.min(min, num);
            count1[num]++;
        }
        Arrays.sort(nums2);
        for (int n : nums2) {
            if (count1[n] > 0) {
                return n;
            }
        }
        return 10 * Math.min(min, nums2[0]) + Math.max(min, nums2[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
