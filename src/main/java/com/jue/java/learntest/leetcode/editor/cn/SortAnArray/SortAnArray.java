//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
//


package com.jue.java.learntest.leetcode.editor.cn.SortAnArray;

import java.util.Arrays;

/**
 * @author JUE
 * @number 912
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
//        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{-1, 2, -8, -10})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 使用快速排序对数组进行排序
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int begin, int end) {
        int key = nums[begin];
        int low = begin, high = end;
        boolean first = true;
        while (low < high) {
            if (first) {
                if (nums[high] < key) {
                    nums[low++] = nums[high];
                    first = false;
                } else {
                    high--;
                }
            } else {
                if (nums[low] > key) {
                    nums[high--] = nums[low];
                    first = true;
                } else {
                    low++;
                }
            }
        }
        nums[low] = key;
        if (begin < low - 1) sortArray(nums, begin, low - 1);
        if (end > high + 1) sortArray(nums, high + 1, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
