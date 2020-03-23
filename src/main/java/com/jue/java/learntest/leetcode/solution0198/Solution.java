package com.jue.java.learntest.leetcode.solution0198;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int[] count = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                max = Math.max(max, count[j]);
            }
            sum = Math.max(sum, (count[i] = nums[i] + max));
        }
        return sum;
    }
}