package com.jue.java.learntest.leetcode.solution0001;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 5};
        solution.twoSum(nums, 9);
    }
}

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