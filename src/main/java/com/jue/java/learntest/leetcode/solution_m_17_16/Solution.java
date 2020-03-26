package com.jue.java.learntest.leetcode.solution_m_17_16;

class Solution {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int max = nums[0];
        int pre = 0;
        int[] result = new int[len];
        result[0] = max;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, (result[i] = pre + nums[i]));
            pre = Math.max(pre, result[i - 1]);
        }
        return max;
    }
}