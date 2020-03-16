package com.jue.java.learntest.leetcode.solution0300;

class Solution {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] answer = new int[nums.length];
        int result = 0;
        for (int index = 0; index < len; index++) {
            int path = 1;
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    path = Math.max(path, answer[j] + 1);
                }
            }
            answer[index] = path;
            result = Math.max(result, path);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] array1 = {0};
        int[] array2 = {2, 2};
        System.out.println((new Solution()).lengthOfLIS(array));
    }
}