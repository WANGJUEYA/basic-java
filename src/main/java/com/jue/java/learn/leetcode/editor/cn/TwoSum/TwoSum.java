//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package com.jue.java.learn.leetcode.editor.cn.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 1
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 5};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 空间复杂度为O(1*n) 时间复杂度为O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// hash存储
class SolutionPerfect {
    // 空间复杂度为O(2*n) 时间复杂度为O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> valueOfIndex = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            int sub = target - num;
            if (valueOfIndex.containsKey(sub)) {
                result[0] = valueOfIndex.get(sub);
                result[1] = i;
                return result;
            }
            valueOfIndex.put(num, i);
        }
        return result;
    }
}