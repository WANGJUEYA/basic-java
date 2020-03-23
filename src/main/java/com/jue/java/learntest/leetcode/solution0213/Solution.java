package com.jue.java.learntest.leetcode.solution0213;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int preMax = 0;
        int currentMax = 0;
        int[] count = new int[len - 1];
        for (int index = 0; index < len - 1; index++) {
            currentMax = Math.max(currentMax, (count[index]) = preMax + nums[index]);
            preMax = index - 1 >= 0 ? Math.max(preMax, count[index - 1]) : preMax;
        }

        preMax = 0;
        int currentMax1 = 0;
        count = new int[len];
        for (int index = 1; index < len; index++) {
            currentMax1 = Math.max(currentMax1, (count[index]) = preMax + nums[index]);
            preMax = Math.max(preMax, count[index - 1]);
        }

        return Math.max(currentMax, currentMax1);
    }
}