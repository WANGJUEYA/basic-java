package com.jue.java.learntest.leetcode.solution0055;

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